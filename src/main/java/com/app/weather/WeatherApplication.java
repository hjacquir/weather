package com.app.weather;

import com.app.weather.service.Factory.ClientFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherApplication implements CommandLineRunner {
	private final ClientFactory clientFactory;

	public WeatherApplication(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	public static void main(String[] args) {
		SpringApplication.run(WeatherApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			clientFactory.create().request();
		} catch (Exception e) {
			System.out.println("An error occurred : " + e.getMessage());
		}
	}
}
