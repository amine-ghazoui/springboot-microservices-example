package org.ghazoui.billingservice;

import org.ghazoui.billingservice.entities.Bill;
import org.ghazoui.billingservice.entities.ProductItem;
import org.ghazoui.billingservice.feign.CustomerRestClient;
import org.ghazoui.billingservice.feign.ProductRestClient;
import org.ghazoui.billingservice.model.Customer;
import org.ghazoui.billingservice.model.Product;
import org.ghazoui.billingservice.repositories.BillRepository;
import org.ghazoui.billingservice.repositories.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(BillRepository  billRepository,
										ProductItemRepository productItemRepository,
										CustomerRestClient customerRestClient,
										ProductRestClient productRestClient){

		return args -> {
			Collection<Customer> customers = customerRestClient.getAllCustomers().getContent();
			Collection<Product> products = productRestClient.getAllProducts().getContent();

			customers.forEach(customer -> {
				Bill bill = Bill.builder()
						.billingDate(new Date())
						.customerId(customer.getId())
						.build();
				billRepository.save(bill);
				products.forEach(product -> {
					ProductItem productItem = ProductItem.builder()
							.bill(bill)
							.productId(product.getId())
							.quantity(1+new Random().nextInt(10))
							.unitPrice(product.getPrice())
							.build();
					productItemRepository.save(productItem);
				});
			});
		};
	}

}
/*
@EnableFeignClients : annotation Spring Boot qui active la détection et l’utilisation
des clients Feign pour appeler facilement des services REST externes via des interfaces Java.
 */
