package com.app.weather.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OpenWeather implements WheatherInterface {
    private Main main;
    private Wind wind;
    private String name;

    public OpenWeather(Main main, Wind wind, String name) {
        this.main = main;
        this.wind = wind;
        this.name = name;
    }

    @Override
    public String __toString() {
        return String.format("Current Location : %s, Temp : %s, Humidity : %s, Wind speed : %s%n", this.getName(), this.main.getTemp(), this.main.getHumidity(), this.getWind().getSpeed());
    }
}
