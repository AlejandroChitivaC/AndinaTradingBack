package com.andinatrading.AndinaTradingBack.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Historial_inversion")
public class HistorialInversion {

    @Id
    @Column(length = 36)
    private String id;

    @Column(name = "inversionista_id", nullable = false)
    private String inversionistaId;

    @Column(name = "saldo_anterior", nullable = false)
    private BigDecimal saldoAnterior;

    @Column(name = "saldo_actual", nullable = false)
    private BigDecimal saldoActual;

    private String descripcion;

    private LocalDateTime fecha = LocalDateTime.now();

    public HistorialInversion() {
    }

    public HistorialInversion(String inversionistaId, BigDecimal saldoAnterior, BigDecimal saldoActual, String descripcion) {
        this.inversionistaId = inversionistaId;
        this.saldoAnterior = saldoAnterior;
        this.saldoActual = saldoActual;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInversionistaId() {
        return inversionistaId;
    }

    public void setInversionistaId(String inversionistaId) {
        this.inversionistaId = inversionistaId;
    }

    public BigDecimal getSaldoAnterior() {
        return saldoAnterior;
    }

    public void setSaldoAnterior(BigDecimal saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    public BigDecimal getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(BigDecimal saldoActual) {
        this.saldoActual = saldoActual;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
