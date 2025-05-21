package com.andinatrading.AndinaTradingBack.repository;

import com.andinatrading.AndinaTradingBack.entity.HistorialInversion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HistorialInversionRepository extends JpaRepository<HistorialInversion, String> {
    List<HistorialInversion> findByInversionistaId(String inversionistaId);
    Optional<HistorialInversion> findTopByInversionistaIdOrderByFechaDesc(String inversionistaId);
}
