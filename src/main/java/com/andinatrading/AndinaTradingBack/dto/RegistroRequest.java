package com.andinatrading.AndinaTradingBack.dto;

import com.andinatrading.AndinaTradingBack.entity.Rol;
import lombok.Data;

@Data
public class RegistroRequest {
    private String nombreCompleto;
    private String identificacion;
    private String correo;
    private String contrasena;
    private Rol rol;
}
