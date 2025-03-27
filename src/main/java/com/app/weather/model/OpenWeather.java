package com.app.weather.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OpenWeather {
    private Main main;
    private Wind wind;
    private String name;

    public OpenWeather(Main main, Wind wind, String name) {
        this.main = main;
        this.wind = wind;
        this.name = name;
    }
}
