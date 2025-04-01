package com.app.weather.controller;

import com.app.weather.form.HomeForm;
import com.app.weather.model.WheatherInterface;
import com.app.weather.service.Client.ClientInterface;
import com.app.weather.service.Factory.ClientFactory;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    private final ClientFactory clientFactory;

    public MainController(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    @GetMapping("/")
    public String home(Model model) {
        if (!model.containsAttribute("HomeForm")) {
            model.addAttribute("HomeForm", new HomeForm());
        }

        return "home";
    }

    @PostMapping("/")
    public String homeSubmit(
            Model model,
            @Valid HomeForm homeForm,
            BindingResult bindingResult
    ) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("HomeForm", homeForm);
            model.addAttribute("errors", bindingResult.getAllErrors());

            return "home";
        }

        ClientInterface client = this.clientFactory.create();
        try {
            WheatherInterface response = client.request(homeForm.getCityName());
            model.addAttribute("response", response.__toString());
        } catch (Exception e) {
            model.addAttribute("response", "Something went wrong : " + e.getMessage());
        }

        return "result";
    }
}
