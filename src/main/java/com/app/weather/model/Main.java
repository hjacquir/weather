package com.app.weather.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Main {
    public String temp;
    public String humidity;

    public Main(String temp, String humidity) {
        this.temp = temp;
        this.humidity = humidity;
    }
}
