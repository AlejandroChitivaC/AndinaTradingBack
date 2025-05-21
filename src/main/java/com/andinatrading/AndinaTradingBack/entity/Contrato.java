package com.andinatrading.AndinaTradingBack.entity;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Contratos")
public class Contrato {

    @Id
    @Column(length = 36)
    private String id;

    @Column(name = "inversionista_id", nullable = false)
    private String inversionistaId;

    @Column(name = "comisionista_id", nullable = false)
    private String comisionistaId;

    @Column(name = "fecha_inicio", nullable = false)
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    private Date fechaFin;

    @Enumerated(EnumType.STRING)
    private EstadoContrato estado;

    // Getters y Setters
    public String getId() {
        return id;
    }

    public String getInversionistaId() {
        return inversionistaId;
    }

    public String getComisionistaId() {
        return comisionistaId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setInversionistaId(String inversionistaId) {
        this.inversionistaId = inversionistaId;
    }

    public void setComisionistaId(String comisionistaId) {
        this.comisionistaId = comisionistaId;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public EstadoContrato getEstado() {
        return estado;
    }

    public void setEstado(EstadoContrato estado) {
        this.estado = estado;
    }
}
