package com.andinatrading.AndinaTradingBack.dto;

import java.util.UUID;

public record OperacionDTO(
    UUID contratoId,
    UUID instrumentoId,
    String tipoOperacion,
    int cantidad
) {}
