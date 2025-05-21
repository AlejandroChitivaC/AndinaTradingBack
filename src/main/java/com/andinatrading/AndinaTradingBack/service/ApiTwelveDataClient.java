package com.andinatrading.AndinaTradingBack.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Component
public class ApiTwelveDataClient {

    @Value("${APIKEY_12_DATA}")
    private String apiKey;

    private static final String BASE_URL = "https://api.twelvedata.com/quote";

    public Map<String, Object> obtenerQuotePorSimbolo(String simbolo) {
        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .queryParam("symbol", simbolo)
                .queryParam("apikey", apiKey)
                .toUriString();

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, Map.class);
    }
}
