package com.andinatrading.AndinaTradingBack.service;

import com.andinatrading.AndinaTradingBack.dto.OperacionDTO;
import com.andinatrading.AndinaTradingBack.entity.*;
import com.andinatrading.AndinaTradingBack.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class OperacionService {

    @Autowired
    private OperacionRepository operacionRepo;

    @Autowired
    private ContratoRepository contratoRepo;

    @Autowired
    private InstrumentoRepository instrumentoRepo;

    @Autowired
    private HistorialInversionRepository historialRepo;

    public void procesarOperacion(OperacionDTO dto) {
        Contrato contrato = contratoRepo.findById(String.valueOf(dto.contratoId()))
                .orElseThrow(() -> new RuntimeException("Contrato no encontrado"));

        Instrumento instrumento = instrumentoRepo.findById(String.valueOf(dto.instrumentoId()))
                .orElseThrow(() -> new RuntimeException("Instrumento no encontrado"));

        BigDecimal precio = instrumento.getPrecioActual();
        BigDecimal total = precio.multiply(BigDecimal.valueOf(dto.cantidad()));

        // ✅ Suponiendo que contrato tiene un campo String inversionistaId
        String inversionistaId = contrato.getInversionistaId();

        // ✅ Obtener saldo anterior o asignar 10 millones por defecto
        BigDecimal saldoAnterior = historialRepo
                .findTopByInversionistaIdOrderByFechaDesc(inversionistaId)
                .map(HistorialInversion::getSaldoActual)
                .orElse(BigDecimal.valueOf(10000000));

        BigDecimal nuevoSaldo;

        if (dto.tipoOperacion().equalsIgnoreCase("COMPRA")) {
            if (saldoAnterior.compareTo(total) < 0) {
                throw new RuntimeException("Saldo insuficiente.");
            }
            nuevoSaldo = saldoAnterior.subtract(total);
            HistorialInversion historial = new HistorialInversion();
            historial.setId(UUID.randomUUID().toString());
            historial.setInversionistaId(inversionistaId);
            historial.setSaldoAnterior(saldoAnterior);
            historial.setSaldoActual(nuevoSaldo);
            historial.setDescripcion("Compra de " + instrumento.getNombre()); // o "Venta de ..."
            historial.setFecha(new Timestamp(System.currentTimeMillis()).toLocalDateTime());
            historialRepo.save(historial);

        } else {
            nuevoSaldo = saldoAnterior.add(total);
            HistorialInversion historial = new HistorialInversion();
            historial.setId(UUID.randomUUID().toString());
            historial.setInversionistaId(inversionistaId);
            historial.setSaldoAnterior(saldoAnterior);
            historial.setSaldoActual(nuevoSaldo);
            historial.setDescripcion("Compra de " + instrumento.getNombre()); // o "Venta de ..."
            historial.setFecha(new Timestamp(System.currentTimeMillis()).toLocalDateTime());
            historialRepo.save(historial);

        }

        Operacion op = new Operacion();
        op.setId(UUID.randomUUID().toString());
        op.setContratoId(contrato.getId());
        op.setInstrumentoId(instrumento.getId());
        op.setTipoOperacion(TipoOperacion.valueOf(dto.tipoOperacion().toUpperCase()));
        op.setCantidad(dto.cantidad());
        op.setPrecioUnitario(precio);
        op.setFechaOperacion(LocalDateTime.now());

        operacionRepo.save(op);
    }
}
