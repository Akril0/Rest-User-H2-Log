package com.example.app.RestUserH2Log;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class RestUserH2LogApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(RestUserH2LogApplication.class)
				.bannerMode(Banner.Mode.OFF)
				.run(args);

		System.out.println("App running ...");
	}

}
