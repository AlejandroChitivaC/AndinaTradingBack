package com.andinatrading.AndinaTradingBack.service;

import com.andinatrading.AndinaTradingBack.dto.InversionistaDTO;
import com.andinatrading.AndinaTradingBack.entity.Inversionista;
import com.andinatrading.AndinaTradingBack.repository.InversionistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
public class InversionistaService {

    @Autowired
    private InversionistaRepository repository;

//    public List<Inversionista> listar() {
//        return repository.obtenerTodosNativo();
//    }

    public Inversionista crear(Inversionista i) {
        System.out.println("== RECIBIDO ==");
        System.out.println("Nombre: " + i.getNombreCompleto());
        System.out.println("Correo: " + i.getCorreo());
        System.out.println("Identificación: " + i.getIdentificacion());
        i.setFechaRegistro(new Timestamp(System.currentTimeMillis()));
        i.setId(UUID.randomUUID().toString()); // asignar UUID manualmente
        return repository.save(i);
    }

    public List<InversionistaDTO> listar() {
        List<Object[]> filas = repository.obtenerCrudo();
        return filas.stream().map(obj -> new InversionistaDTO(
                (String) obj[0],
                (String) obj[1],
                (String) obj[2],
                (String) obj[3],
                obj[4] != null ? obj[4].toString() : null
        )).toList();
    }

}
