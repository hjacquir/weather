package com.app.weather.service.Client;

public class NullClient implements ClientInterface {
    @Override
    public String request(String cityName) {
        return "";
    }
}
