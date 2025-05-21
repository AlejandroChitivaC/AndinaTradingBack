package com.andinatrading.AndinaTradingBack.repository;

import com.andinatrading.AndinaTradingBack.entity.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContratoRepository extends JpaRepository<Contrato, String> {
    List<Contrato> findByComisionistaId(String comisionistaId);
    List<Contrato> findByInversionistaId(String inversionistaId); // si ya tienes este, déjalo
}
