package com.andinatrading.AndinaTradingBack.controller;

import com.andinatrading.AndinaTradingBack.dto.LoginRequest;
import com.andinatrading.AndinaTradingBack.dto.LoginResponse;
import com.andinatrading.AndinaTradingBack.dto.RegistroComisionistaRequest;
import com.andinatrading.AndinaTradingBack.dto.RegistroInversionistaRequest;
import com.andinatrading.AndinaTradingBack.entity.Comisionista;
import com.andinatrading.AndinaTradingBack.entity.Inversionista;
import com.andinatrading.AndinaTradingBack.entity.Usuario;
import com.andinatrading.AndinaTradingBack.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register/inversionista")
    public ResponseEntity<Usuario> registrarInversionista(@RequestBody RegistroInversionistaRequest request) {
        Usuario usuario = new Usuario();
        usuario.setCorreo(request.getCorreo());
        usuario.setContrasena(request.getContrasena());

        Inversionista inversionista = new Inversionista();
        inversionista.setCorreo(request.getCorreo());
        inversionista.setNombreCompleto(request.getNombreCompleto());
        inversionista.setIdentificacion(request.getIdentificacion());

        return ResponseEntity.ok(authService.registrarInversionista(usuario, inversionista));
    }

    @PostMapping("/register/comisionista")
    public ResponseEntity<Usuario> registrarComisionista(@RequestBody RegistroComisionistaRequest request) {
        Usuario usuario = new Usuario();
        usuario.setCorreo(request.getCorreo());
        usuario.setContrasena(request.getContrasena());

        Comisionista comisionista = new Comisionista();
        comisionista.setCorreo(request.getCorreo());
        comisionista.setNombreCompleto(request.getNombreCompleto());
        comisionista.setIdentificacion(request.getIdentificacion());

        return ResponseEntity.ok(authService.registrarComisionista(usuario, comisionista));
    }
}
