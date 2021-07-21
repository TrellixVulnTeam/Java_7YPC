package com.example.springboot;

import java.util.Arrays;

import com.example.springboot.storage.StorageProperties;
import com.example.springboot.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return(args) -> {
			try {
				storageService.deleteAll();
				storageService.init();
			}
			catch(Exception ex) {
				System.out.println("-----Problem---");
			}
		};
	}
}
