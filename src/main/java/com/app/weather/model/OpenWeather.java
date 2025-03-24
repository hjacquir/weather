package com.app.weather.model.OpenWeather;

public class OpenWeather {
    private Main main;
    private Wind wind;
    private String name;

    public OpenWeather(Main main, Wind wind, String name) {
        this.main = main;
        this.wind = wind;
        this.name = name;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
