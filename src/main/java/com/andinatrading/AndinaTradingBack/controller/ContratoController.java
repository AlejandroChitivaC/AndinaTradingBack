package com.andinatrading.AndinaTradingBack.controller;

import com.andinatrading.AndinaTradingBack.entity.Contrato;
import com.andinatrading.AndinaTradingBack.entity.EstadoContrato;
import com.andinatrading.AndinaTradingBack.repository.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.UUID;

@RestController
@RequestMapping("/api/contratos")
@CrossOrigin(origins = "*")
public class ContratoController {

    @Autowired
    private ContratoRepository contratoRepo;

    @PostMapping
    public ResponseEntity<Contrato> crearContrato(@RequestBody Contrato contrato) {
        contrato.setId(UUID.randomUUID().toString());
        contrato.setEstado(EstadoContrato.ACTIVO);
        contrato.setFechaInicio(new Date(System.currentTimeMillis()));
        return ResponseEntity.ok(contratoRepo.save(contrato));
    }
}
