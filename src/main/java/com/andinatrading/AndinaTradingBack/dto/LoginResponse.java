package com.andinatrading.AndinaTradingBack.dto;

public class LoginResponse {
    private String token;
    private String rol;
    private String nombre;
    private String id;

    public LoginResponse() {
    }

    public LoginResponse(String token, String rol, String nombre, String id) {
        this.token = token;
        this.rol = rol;
        this.nombre=nombre;
        this.id = id;
    }

    // Getters y Setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRol() {
        return rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
