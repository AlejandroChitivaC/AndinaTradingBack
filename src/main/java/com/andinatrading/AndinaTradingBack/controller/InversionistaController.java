package com.andinatrading.AndinaTradingBack.controller;

import com.andinatrading.AndinaTradingBack.dto.InversionistaDTO;
import com.andinatrading.AndinaTradingBack.entity.Inversionista;
import com.andinatrading.AndinaTradingBack.service.InversionistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.RouteMatcher;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inversionistas")
@CrossOrigin(origins = "*")
public class InversionistaController {

    @Autowired
    private InversionistaService service;

    @GetMapping
    public List<InversionistaDTO> listar() {
        return service.listar();
    }

    @PostMapping("/registro")
    public Inversionista crear(@RequestBody Inversionista inversionista) {
        return service.crear(inversionista);
    }
}
