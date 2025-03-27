package com.app.weather.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Wind {
    private String speed;

    public Wind(String speed) {
        this.speed = speed;
    }
}
