package com.example.currentWeather.service.Factory;

import com.example.currentWeather.service.Client.ClientInterface;
import com.example.currentWeather.service.Client.NullClient;
import com.example.currentWeather.service.Client.OpenWeather;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ClientFactory {
    @Value("${provider.current}")
    private String currentProvider;
    @Value("${openweather.key}")
    private String openWeatherApiKey;
    @Value("${openweather.baseUrl}")
    private String openWeatherbaseUrl;
    private final RestClientFactory restClientFactory;

    public ClientFactory(RestClientFactory restClientFactory) {
        this.restClientFactory = restClientFactory;
    }

    public ClientInterface create() {
        if ("openweather".equals(currentProvider)) {
            return new OpenWeather(restClientFactory.create(), openWeatherApiKey, openWeatherbaseUrl);
        }
        // todo manage
        return new NullClient();
    }
}
