package com.app.weather.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class HomeForm {
    @Size(min=4, message = "Enter at least 4 characters")
    @NotEmpty(message = "City name is required")
    private String cityName;
}
