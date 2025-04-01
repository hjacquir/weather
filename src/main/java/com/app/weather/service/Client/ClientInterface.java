package com.app.weather.service.Client;

import com.app.weather.model.WheatherInterface;

public interface ClientInterface {
    public WheatherInterface request(String cityName) throws Exception;
}
