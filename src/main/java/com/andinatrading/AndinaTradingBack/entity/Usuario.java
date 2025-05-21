package com.andinatrading.AndinaTradingBack.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @Column(length = 36)
    private String id;

    @Column(nullable = false, unique = true)
    private String correo;

    @Column(nullable = false)
    private String contrasena;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Rol rol;

    @Column(nullable = false)
    private Boolean activo;

    public String getId() {
        return id;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public Rol getRol() {
        return rol;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
