package com.andinatrading.AndinaTradingBack.repository;

import com.andinatrading.AndinaTradingBack.entity.Inversionista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface InversionistaRepository extends JpaRepository<Inversionista, String> {
    boolean existsByCorreo(String correo);

    boolean existsByIdentificacion(String identificacion);

    @Query(value = "SELECT * FROM Inversionistas", nativeQuery = true)
    List<Inversionista> obtenerTodosNativo();

    @Query(value = "SELECT id, nombre_completo, correo, identificacion, fecha_registro FROM Inversionistas", nativeQuery = true)
    List<Object[]> obtenerCrudo();
    Optional<Inversionista> findByCorreo(String correo);
    Optional<Inversionista> findByUsuarioId(String usuarioId);
}
