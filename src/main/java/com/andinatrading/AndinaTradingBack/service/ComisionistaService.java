package com.andinatrading.AndinaTradingBack.service;

import com.andinatrading.AndinaTradingBack.dto.ComisionistaDTO;
import com.andinatrading.AndinaTradingBack.entity.*;
import com.andinatrading.AndinaTradingBack.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class ComisionistaService {

    @Autowired
    private ComisionistaRepository repository;

    public List<ComisionistaDTO> listar() {
        List<Object[]> filas = repository.obtenerCrudo();
        return filas.stream().map(obj -> new ComisionistaDTO(
                (String) obj[0],
                (String) obj[1],
                (String) obj[2],
                (String) obj[3],
                (Boolean) obj[4],
                obj[5] != null ? obj[5].toString() : null
        )).toList();
    }


    public Comisionista crear(Comisionista c) {
        c.setId(UUID.randomUUID().toString());
        c.setActivo(true);
        c.setFechaIngreso(new Timestamp(System.currentTimeMillis()));
        return repository.save(c);
    }

    public List<Map<String, Object>> obtenerAsignacionesPorComisionista(String comisionistaId,
                                                                        ContratoRepository contratoRepo,
                                                                        OperacionRepository operacionRepo,
                                                                        InversionistaRepository inversionistaRepo,
                                                                        InstrumentoRepository instrumentoRepo) {
        List<Map<String, Object>> resultado = new ArrayList<>();

        List<Contrato> contratos = contratoRepo.findByComisionistaId(comisionistaId);

        for (Contrato contrato : contratos) {
            List<Operacion> operaciones = operacionRepo.findByContratoId(contrato.getId());

            for (Operacion op : operaciones) {
                Map<String, Object> map = new HashMap<>();
                Inversionista inv = inversionistaRepo.findById(contrato.getInversionistaId()).orElse(null);
                Instrumento inst = instrumentoRepo.findById(op.getInstrumentoId()).orElse(null);

                map.put("nombreInversionista", inv != null ? inv.getNombreCompleto() : "N/A");
                map.put("tipoOperacion", op.getTipoOperacion().name());
                map.put("cantidad", op.getCantidad());
                map.put("precioUnitario", op.getPrecioUnitario());
                map.put("fechaOperacion", op.getFechaOperacion());
                map.put("instrumento", inst != null ? inst.getSimbolo() : "N/A");

                resultado.add(map);
            }
        }

        return resultado;
    }

}
