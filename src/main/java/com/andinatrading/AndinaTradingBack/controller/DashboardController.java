package com.andinatrading.AndinaTradingBack.controller;

import com.andinatrading.AndinaTradingBack.entity.Contrato;
import com.andinatrading.AndinaTradingBack.entity.HistorialInversion;
import com.andinatrading.AndinaTradingBack.entity.Inversionista;
import com.andinatrading.AndinaTradingBack.entity.Operacion;
import com.andinatrading.AndinaTradingBack.repository.ContratoRepository;
import com.andinatrading.AndinaTradingBack.repository.HistorialInversionRepository;
import com.andinatrading.AndinaTradingBack.repository.InversionistaRepository;
import com.andinatrading.AndinaTradingBack.repository.OperacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "*")
public class DashboardController {

    @Autowired
    private InversionistaRepository inversionistaRepo;

    @Autowired
    private HistorialInversionRepository historialRepo;

    @Autowired
    private ContratoRepository contratoRepo;

    @Autowired
    private OperacionRepository operacionRepo;

    @GetMapping("/inversionista/usuario/{usuarioId}")
    public ResponseEntity<?> obtenerDashboardPorUsuario(@PathVariable String usuarioId) {
        Inversionista inversionista = inversionistaRepo.findByUsuarioId(usuarioId)
                .orElseThrow(() -> new RuntimeException("Inversionista no encontrado"));

        String inversionistaId = inversionista.getId();

        BigDecimal saldoActual = historialRepo
                .findTopByInversionistaIdOrderByFechaDesc(inversionistaId)
                .map(HistorialInversion::getSaldoActual)
                .orElse(BigDecimal.valueOf(10000000)); // default inicial

        List<Contrato> contratos = contratoRepo.findByInversionistaId(inversionistaId);

        List<String> contratoIds = contratos.stream()
                .map(Contrato::getId)
                .collect(Collectors.toList());

        List<Operacion> ultimasOperaciones = operacionRepo
                .findTop5ByContratoIdInOrderByFechaOperacionDesc(contratoIds);

        Map<String, Object> data = new HashMap<>();
        data.put("saldo", saldoActual);
        data.put("operaciones", ultimasOperaciones);

        return ResponseEntity.ok(data);
    }
}
