package org.ghazoui.inventoryservice;

import org.ghazoui.inventoryservice.entities.Product;
import org.ghazoui.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ProductRepository productRepository) {
		return args -> {
			productRepository.save(Product.builder()
					.id(UUID.randomUUID().toString())
					.name("Computer")
					.price(3000)
					.quantity(12)
					.build());

			productRepository.save(Product.builder()
					.id(UUID.randomUUID().toString())
					.name("Printer")
					.price(300)
					.quantity(19)
					.build());

			productRepository.save(Product.builder()
					.id(UUID.randomUUID().toString())
					.name("Smartphone")
					.price(5000)
					.quantity(8)
					.build());

			productRepository.findAll().forEach(product -> {
				System.out.println(product.toString());
				System.out.println("******************************");
			});
		};
	}
}