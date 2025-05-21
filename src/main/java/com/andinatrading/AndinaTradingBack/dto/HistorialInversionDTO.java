package com.andinatrading.AndinaTradingBack.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class HistorialInversionDTO {

    private String tipoOperacion;
    private int cantidad;
    private BigDecimal precioUnitario;
    private LocalDateTime fechaOperacion;
    private String simbolo;

    public HistorialInversionDTO() {}

    public HistorialInversionDTO(String tipoOperacion, int cantidad, BigDecimal precioUnitario, LocalDateTime fechaOperacion, String simbolo) {
        this.tipoOperacion = tipoOperacion;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.fechaOperacion = fechaOperacion;
        this.simbolo = simbolo;
    }

    public String getTipoOperacion() { return tipoOperacion; }
    public void setTipoOperacion(String tipoOperacion) { this.tipoOperacion = tipoOperacion; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public BigDecimal getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(BigDecimal precioUnitario) { this.precioUnitario = precioUnitario; }

    public LocalDateTime getFechaOperacion() { return fechaOperacion; }
    public void setFechaOperacion(LocalDateTime fechaOperacion) { this.fechaOperacion = fechaOperacion; }

    public String getSimbolo() { return simbolo; }
    public void setSimbolo(String simbolo) { this.simbolo = simbolo; }
}
