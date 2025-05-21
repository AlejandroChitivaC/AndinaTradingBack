package com.andinatrading.AndinaTradingBack.controller;

import com.andinatrading.AndinaTradingBack.dto.ComisionistaDTO;
import com.andinatrading.AndinaTradingBack.entity.Comisionista;
import com.andinatrading.AndinaTradingBack.service.ComisionistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comisionistas")
@CrossOrigin(origins = "*")
public class ComisionistaController {

    @Autowired
    private ComisionistaService service;

    @GetMapping
    public List<ComisionistaDTO> listar() {
        return service.listar();
    }


    @PostMapping("/registro")
    public Comisionista crear(@RequestBody Comisionista comisionista) {
        return service.crear(comisionista);
    }
}
