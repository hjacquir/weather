package com.app.weather.model.OpenWeather;

public class Main {
    public String temp;
    public String humidity;

    public Main(String temp, String humidity) {
        this.temp = temp;
        this.humidity = humidity;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }
}
