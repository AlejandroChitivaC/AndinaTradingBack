package com.andinatrading.AndinaTradingBack.service;

import com.andinatrading.AndinaTradingBack.dto.LoginRequest;
import com.andinatrading.AndinaTradingBack.dto.LoginResponse;
import com.andinatrading.AndinaTradingBack.entity.*;
import com.andinatrading.AndinaTradingBack.repository.ComisionistaRepository;
import com.andinatrading.AndinaTradingBack.repository.InversionistaRepository;
import com.andinatrading.AndinaTradingBack.repository.UsuarioRepository;
import com.andinatrading.AndinaTradingBack.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private InversionistaRepository inversionistaRepository;

    @Autowired
    private ComisionistaRepository comisionistaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public Usuario registrarInversionista(Usuario usuario, Inversionista inversionista) {
        if (usuarioRepository.findByCorreo(usuario.getCorreo()).isPresent()) {
            throw new RuntimeException("El correo ya está registrado");
        }

        usuario.setId(UUID.randomUUID().toString());
        usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
        usuario.setActivo(true);
        usuario.setRol(Rol.INVERSIONISTA);
        usuarioRepository.save(usuario);

        inversionista.setId(UUID.randomUUID().toString());
        inversionista.setFechaRegistro(new java.sql.Timestamp(System.currentTimeMillis()));
        inversionista.setUsuarioId(usuario.getId());
        inversionistaRepository.save(inversionista);

        return usuario;
    }

    public Usuario registrarComisionista(Usuario usuario, Comisionista comisionista) {
        if (usuarioRepository.findByCorreo(usuario.getCorreo()).isPresent()) {
            throw new RuntimeException("El correo ya está registrado");
        }

        usuario.setId(UUID.randomUUID().toString());
        usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
        usuario.setActivo(true);
        usuario.setRol(Rol.COMISIONISTA);
        usuarioRepository.save(usuario);

        comisionista.setId(UUID.randomUUID().toString());
        comisionista.setActivo(true);
        comisionista.setFechaIngreso(new java.sql.Timestamp(System.currentTimeMillis()));
        comisionista.setUsuarioId(usuario.getId());
        comisionistaRepository.save(comisionista);

        return usuario;
    }

    public LoginResponse login(LoginRequest request) {
        Usuario usuario = usuarioRepository.findByCorreo(request.getCorreo())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        System.out.println("Contraseña enviada: " + request.getContrasena());
        System.out.println("Contraseña en BD: " + usuario.getContrasena());

        if (!passwordEncoder.matches(request.getContrasena(), usuario.getContrasena())) {
            throw new RuntimeException("Credenciales inválidas");
        }

        String token = jwtUtil.generarToken(usuario.getCorreo(), usuario.getRol().name());
        String nombreCompleto = "";

        switch (usuario.getRol()) {
            case INVERSIONISTA -> {
                Inversionista inv = inversionistaRepository.findByCorreo(usuario.getCorreo())
                        .orElseThrow(() -> new RuntimeException("Inversionista no encontrado"));
                nombreCompleto = inv.getNombreCompleto();
            }
            case COMISIONISTA -> {
                Comisionista com = comisionistaRepository.findByCorreo(usuario.getCorreo())
                        .orElseThrow(() -> new RuntimeException("Comisionista no encontrado"));
                nombreCompleto = com.getNombreCompleto();
            }
            case ADMIN -> nombreCompleto = "Administrador";
        }

        return new LoginResponse(token, usuario.getRol().name(), nombreCompleto, usuario.getId());
    }
}
