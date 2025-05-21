package com.andinatrading.AndinaTradingBack.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "Instrumentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Instrumento {

    @Id
    @Column(length = 36)
    private String id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String simbolo;

    @Column(nullable = false)
    private String tipo;

    @Column(name = "precio_actual", nullable = false)
    private BigDecimal precioActual;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPrecioActual(BigDecimal precioActual) {
        this.precioActual = precioActual;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public String getTipo() {
        return tipo;
    }

    public BigDecimal getPrecioActual() {
        return precioActual;
    }
}
