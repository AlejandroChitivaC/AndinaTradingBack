package com.andinatrading.AndinaTradingBack.controller;

import com.andinatrading.AndinaTradingBack.dto.HistorialInversionDTO;
import com.andinatrading.AndinaTradingBack.dto.OperacionDTO;
import com.andinatrading.AndinaTradingBack.entity.Contrato;
import com.andinatrading.AndinaTradingBack.entity.Instrumento;
import com.andinatrading.AndinaTradingBack.entity.Operacion;
import com.andinatrading.AndinaTradingBack.repository.ContratoRepository;
import com.andinatrading.AndinaTradingBack.repository.InstrumentoRepository;
import com.andinatrading.AndinaTradingBack.repository.OperacionRepository;
import com.andinatrading.AndinaTradingBack.service.OperacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/operaciones")
public class OperacionController {

    @Autowired
    private OperacionService operacionService;

    @Autowired
    private ContratoRepository contratoRepo;

    @Autowired
    private OperacionRepository operacionRepo;

    @Autowired
    private InstrumentoRepository instrumentoRepo;

    @PostMapping
    public ResponseEntity<?> registrarOperacion(@RequestBody OperacionDTO dto) {
        operacionService.procesarOperacion(dto);
        return ResponseEntity.ok("Operación registrada con éxito");
    }

    @GetMapping("/inversionista/{id}")
    public ResponseEntity<List<HistorialInversionDTO>> listarOperaciones(@PathVariable String id) {
        List<Contrato> contratos = contratoRepo.findByInversionistaId(id);
        List<HistorialInversionDTO> historial = new ArrayList<>();

        for (Contrato contrato : contratos) {
            List<Operacion> operaciones = operacionRepo.findByContratoId(contrato.getId());

            for (Operacion op : operaciones) {
                Instrumento instrumento = instrumentoRepo.findById(op.getInstrumentoId()).orElse(null);
                String simbolo = instrumento != null ? instrumento.getSimbolo() : "N/A";

                historial.add(new HistorialInversionDTO(
                        op.getTipoOperacion().name(),
                        op.getCantidad(),
                        op.getPrecioUnitario(),
                        op.getFechaOperacion(),
                        simbolo
                ));
            }
        }

        return ResponseEntity.ok(historial);
    }
}
