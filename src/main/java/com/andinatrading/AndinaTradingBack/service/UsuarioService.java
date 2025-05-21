package com.andinatrading.AndinaTradingBack.service;

import com.andinatrading.AndinaTradingBack.entity.Usuario;
import com.andinatrading.AndinaTradingBack.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario crearUsuario(Usuario usuario) {
        usuario.setId(UUID.randomUUID().toString());
        usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
        usuario.setActivo(true);
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscarPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }
}
