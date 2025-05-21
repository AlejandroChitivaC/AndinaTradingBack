package com.andinatrading.AndinaTradingBack.repository;

import com.andinatrading.AndinaTradingBack.entity.Comisionista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ComisionistaRepository extends JpaRepository<Comisionista, String> {
    boolean existsByCorreo(String correo);

    boolean existsByIdentificacion(String identificacion);

    @Query(value = "SELECT id, nombre_completo, correo, identificacion, activo, fecha_ingreso FROM Comisionistas", nativeQuery = true)
    List<Object[]> obtenerCrudo();
    Optional<Comisionista> findByCorreo(String correo);

}
