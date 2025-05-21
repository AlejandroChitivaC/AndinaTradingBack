package com.andinatrading.AndinaTradingBack.dto;

public class ComisionistaDTO {
    private String id;
    private String nombreCompleto;
    private String correo;
    private String identificacion;
    private Boolean activo;
    private String fechaIngreso;

    public ComisionistaDTO() {}

    public ComisionistaDTO(String id, String nombreCompleto, String correo, String identificacion, Boolean activo, String fechaIngreso) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.identificacion = identificacion;
        this.activo = activo;
        this.fechaIngreso = fechaIngreso;
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

    public Boolean getActivo() {
        return activo;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
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

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}
