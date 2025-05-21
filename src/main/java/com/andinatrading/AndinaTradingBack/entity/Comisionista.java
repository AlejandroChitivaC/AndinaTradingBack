package com.andinatrading.AndinaTradingBack.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "Comisionistas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comisionista {

    @Setter
    @Id
    @Column(length = 36)
    private String id;

    @Setter
    @Column(name = "nombre_completo", nullable = false)
    private String nombreCompleto;

    @Setter
    @Column(nullable = false, unique = true)
    private String correo;

    @Setter
    @Column(nullable = false, unique = true)
    private String identificacion;

    @Setter
    @Column(nullable = false)
    private Boolean activo;

    @Setter
    @Column(name = "fecha_ingreso")
    private Timestamp fechaIngreso;

    @Column(name = "usuario_id")
    private String usuarioId;


    public Comisionista withUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Timestamp getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Timestamp fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }
}
