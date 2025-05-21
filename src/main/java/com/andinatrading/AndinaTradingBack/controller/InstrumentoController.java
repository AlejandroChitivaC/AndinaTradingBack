package com.andinatrading.AndinaTradingBack.controller;

import com.andinatrading.AndinaTradingBack.entity.Instrumento;
import com.andinatrading.AndinaTradingBack.repository.InstrumentoRepository;
import com.andinatrading.AndinaTradingBack.service.InstrumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instrumentos")
@CrossOrigin(origins = "*")
public class InstrumentoController {

    @Autowired
    private InstrumentoService service;
    @Autowired
    private InstrumentoRepository repository;

    @PostMapping("/sincronizar")
    public String sincronizar() {
        service.sincronizarInstrumentos();
        return "Instrumentos sincronizados correctamente.";
    }
    @GetMapping
    public List<Instrumento> listarInstrumentos() {
        return repository.findAll();
    }
}
