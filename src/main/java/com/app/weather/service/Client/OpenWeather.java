package com.app.weather.service.Client;

import com.app.weather.model.WheatherInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;

public class OpenWeather implements ClientInterface {
    private final RestClient restClient;
    private final String apiKey;
    private final String baseUrl;

    public OpenWeather(RestClient restClient, String apiKey, String baseUrl) {
        this.restClient = restClient;
        this.apiKey = apiKey;
        this.baseUrl = baseUrl;
    }

    public WheatherInterface request(String cityName) throws Exception {
        String apiUri = String.format("%s?appid=%s&q=%s", this.baseUrl, this.apiKey, cityName);

        ResponseEntity<com.app.weather.model.OpenWeather> responseEntity = this.restClient.get().uri(apiUri).retrieve().toEntity(com.app.weather.model.OpenWeather.class);

        return responseEntity.getBody();
    }
}
