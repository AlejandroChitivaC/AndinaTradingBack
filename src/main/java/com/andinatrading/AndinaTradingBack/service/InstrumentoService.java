package com.andinatrading.AndinaTradingBack.service;

import com.andinatrading.AndinaTradingBack.entity.Instrumento;
import com.andinatrading.AndinaTradingBack.repository.InstrumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class InstrumentoService {

    @Autowired
    private ApiTwelveDataClient apiClient;

    @Autowired
    private InstrumentoRepository repository;

    public void sincronizarInstrumentos() {
        List<String> simbolos = List.of(
            "AAPL", "MSFT", "GOOGL", "AMZN", "TSLA", "NVDA", "META", "BRK.B", "JPM", "V",
            "UNH", "MA", "HD", "PG", "XOM", "BAC", "DIS", "KO", "PEP", "CSCO",
            "INTC", "CMCSA", "PFE", "CVX", "WFC", "T", "BA", "VZ", "ADBE", "NFLX",
            "ABBV", "TMO", "ABT", "CRM", "ACN", "COST", "MDT", "MCD", "QCOM", "TXN",
            "NEE", "AMGN", "ORCL", "HON", "IBM", "LIN", "DHR", "LOW", "NKE", "SBUX",
            "UPS", "RTX", "CAT", "SPGI", "BLK", "MDLZ", "AXP", "LMT", "INTU", "GILD",
            "ISRG", "GE", "DUK", "SO", "BKNG", "ZTS", "PLD", "ADI", "SYK", "CI",
            "MO", "TGT", "USB", "DE", "REGN", "BDX", "APD", "CB", "MMC", "ADP",
            "PNC", "C", "SHW", "GM", "CSX", "ITW", "ETN", "FIS", "EMR", "ECL",
            "FDX", "NSC", "GD", "AON", "PSA", "CL", "ALL", "EXC", "HUM", "MAR"
        );

        for (String simbolo : simbolos) {
            Map<String, Object> respuesta = apiClient.obtenerQuotePorSimbolo(simbolo);

            if (respuesta.containsKey("symbol") && respuesta.get("close") != null) {
                String simboloObtenido = (String) respuesta.get("symbol");
                Optional<Instrumento> existente = repository.findBySimbolo(simboloObtenido);

                if (existente.isPresent()) {
                    Instrumento inst = existente.get();
                    inst.setNombre((String) respuesta.get("name"));
                    inst.setPrecioActual(new BigDecimal((String) respuesta.get("close")));
                    repository.save(inst); // actualiza
                } else {
                    Instrumento inst = new Instrumento();
                    inst.setId(UUID.randomUUID().toString());
                    inst.setNombre((String) respuesta.get("name"));
                    inst.setSimbolo(simboloObtenido);
                    inst.setTipo("acción");
                    inst.setPrecioActual(new BigDecimal((String) respuesta.get("close")));
                    repository.save(inst); // inserta
                }
            }
        }
    }
}
