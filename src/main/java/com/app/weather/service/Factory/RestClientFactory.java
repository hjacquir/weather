package com.example.currentWeather.service.Factory;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class RestClientFactory {
    public RestClient create() {
        return RestClient.create();
    }
}
