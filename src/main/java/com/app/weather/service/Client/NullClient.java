package com.app.weather.service.Client;

import com.app.weather.model.NullWeather;
import com.app.weather.model.WheatherInterface;

public class NullClient implements ClientInterface {
    @Override
    public WheatherInterface request(String cityName) throws Exception {
        return new NullWeather("Null client request");
    }
}
