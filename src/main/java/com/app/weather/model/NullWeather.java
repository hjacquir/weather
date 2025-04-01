package com.app.weather.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NullWeather implements WheatherInterface {
    private String message;

    public NullWeather(String message) {
        this.message = message;
    }

    @Override
    public String __toString() {
        return "Provider is null : " + message;
    }
}
