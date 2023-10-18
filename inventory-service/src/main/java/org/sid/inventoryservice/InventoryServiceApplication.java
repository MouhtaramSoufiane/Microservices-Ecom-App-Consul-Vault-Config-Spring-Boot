package org.sid.inventoryservice;

import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.repo.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import java.util.Random;


@SpringBootApplication
//Automatically do register into consul discovery
@EnableDiscoveryClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(ProductRepository productRepository){
		return args -> {
			for (int i = 0; i < 10; i++) {
				productRepository.save(
						Product.builder()
								.name("Laptop"+i+1)
								.price(1200+Math.random()*10000)
								.quantity(1+new Random().nextInt(200))
								.build()

				);
			}

		};

	}

}
