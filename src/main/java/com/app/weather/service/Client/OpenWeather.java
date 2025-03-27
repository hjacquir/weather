package com.app.weather.service.Client;

import com.app.weather.model.Main;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;

import java.util.Scanner;

public class OpenWeather implements ClientInterface {
    private final RestClient restClient;
    private final String apiKey;
    private final String baseUrl;

    public OpenWeather(RestClient restClient, String apiKey, String baseUrl) {
        this.restClient = restClient;
        this.apiKey = apiKey;
        this.baseUrl = baseUrl;
    }

    public void request() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the city name : ");

        String cityName = scanner.next();
        String apiUri = String.format("%s?appid=%s&q=%s", this.baseUrl, this.apiKey, cityName);

        try {
            ResponseEntity<com.app.weather.model.OpenWeather> responseEntity = this.restClient.get().uri(apiUri).retrieve().toEntity(com.app.weather.model.OpenWeather.class);
            com.app.weather.model.OpenWeather response = responseEntity.getBody();

            assert response != null;

            Main main = response.getMain();

            System.out.printf("Current Location : %s, Temp : %s, Humidity : %s, Wind speed : %s%n", response.getName(), main.getTemp(), main.getHumidity(), response.getWind().getSpeed());
        } catch (Exception e) {
            System.out.println("An error occurred : " + e.getMessage());
        }
    }
}
