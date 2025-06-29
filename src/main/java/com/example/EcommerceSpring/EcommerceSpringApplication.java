package com.example.EcommerceSpring;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvEntry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommerceSpringApplication {

	public static void main(String[] args) {

//		Load Environment Variable from .env file
		Dotenv dotenv = Dotenv.configure().load();

//		set system properties from environment variable and set them
		dotenv.entries().forEach(  entry -> System.setProperty(entry.getKey(),entry.getValue()));
		SpringApplication.run(EcommerceSpringApplication.class, args);
	}

}
