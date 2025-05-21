package com.andinatrading.AndinaTradingBack.repository;

import com.andinatrading.AndinaTradingBack.entity.Instrumento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InstrumentoRepository extends JpaRepository<Instrumento, String> {

    Optional<Instrumento> findBySimbolo(String simbolo);
}
