package com.app.weather.controller;

import com.app.weather.form.HomeForm;
import com.app.weather.model.NullWeather;
import com.app.weather.model.WheatherInterface;
import com.app.weather.service.Factory.ClientFactory;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final ClientFactory clientFactory;

    public ApiController(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    @GetMapping("/weather")
    public WheatherInterface getWeather(@Valid @RequestBody HomeForm homeForm) {
        try {
            return this.clientFactory.create().request(homeForm.getCityName());
        } catch (Exception e) {
            return new NullWeather(e.getMessage());
        }
    }
}
