package com.app.weather.controller;

import com.app.weather.service.Client.ClientInterface;
import com.app.weather.service.Factory.ClientFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    private final ClientFactory clientFactory;

    public MainController(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("/")
    public String homeSubmit(@RequestParam("cityName") String cityName, ModelMap model) {
        ClientInterface client = this.clientFactory.create();
        String response = client.request(cityName);

        model.addAttribute("response", response);

        return "result";
    }
}
