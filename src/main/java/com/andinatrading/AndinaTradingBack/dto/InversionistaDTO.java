package com.andinatrading.AndinaTradingBack.dto;

public class InversionistaDTO {
    private String id;
    private String nombreCompleto;
    private String correo;
    private String identificacion;
    private String fechaRegistro;

    public InversionistaDTO() {}

    public InversionistaDTO(String id, String nombreCompleto, String correo, String identificacion, String fechaRegistro) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.identificacion = identificacion;
        this.fechaRegistro = fechaRegistro;
    }

    public String getId() {
        return id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getCorreo() {
        return correo;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
