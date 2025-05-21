package com.andinatrading.AndinaTradingBack.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Operaciones")
public class Operacion {

    @Id
    @Column(length = 36)
    private String id;

    @Column(name = "contrato_id", nullable = false)
    private String contratoId;

    @Column(name = "instrumento_id", nullable = false)
    private String instrumentoId;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_operacion", nullable = false)
    private TipoOperacion tipoOperacion;

    private int cantidad;

    @Column(name = "precio_unitario", nullable = false)
    private BigDecimal precioUnitario;

    @Column(name = "fecha_operacion")
    private LocalDateTime fechaOperacion = LocalDateTime.now();

    // Getters y Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContratoId() {
        return contratoId;
    }

    public void setContratoId(String contratoId) {
        this.contratoId = contratoId;
    }

    public String getInstrumentoId() {
        return instrumentoId;
    }

    public void setInstrumentoId(String instrumentoId) {
        this.instrumentoId = instrumentoId;
    }

    public TipoOperacion getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(TipoOperacion tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public LocalDateTime getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(LocalDateTime fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }
}
