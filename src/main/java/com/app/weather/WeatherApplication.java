package com.app.weather;

import com.app.weather.service.Factory.ClientFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

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
	public void run(String... args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the city name : ");

		String cityName = scanner.next();

		String response = clientFactory.create().request(cityName);

		System.out.println(response);
	}
}
