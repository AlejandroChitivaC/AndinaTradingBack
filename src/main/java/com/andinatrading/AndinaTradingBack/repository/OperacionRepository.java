package com.andinatrading.AndinaTradingBack.repository;

import com.andinatrading.AndinaTradingBack.entity.Operacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OperacionRepository extends JpaRepository<Operacion, String> {
    List<Operacion> findByContratoId(String contratoId);

    List<Operacion> findTop5ByContratoIdInOrderByFechaOperacionDesc(List<String> contratoIds);
}

