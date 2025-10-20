package org.ghazoui.customerservice;

import org.ghazoui.customerservice.entities.Customer;
import org.ghazoui.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		return args ->{
			customerRepository.save(Customer.builder()
					.name("Amine").email("amineGha2001@gmail.com")
					.build());
			customerRepository.save(Customer.builder()
					.name("Ikram").email("ikram01@gmail.com")
					.build());
			customerRepository.save(Customer.builder()
					.name("Mohamed").email("mohamed21@gmail.com")
					.build());
			customerRepository.save(Customer.builder()
					.name("Imane").email("imageG12@gmail.com")
					.build());

			customerRepository.findAll().forEach(customer -> {
				System.out.println("*****************************************************");
				System.out.println(customer.getId());
				System.out.println(customer.getName());
				System.out.println(customer.getEmail());
				System.out.println("*****************************************************");
			});
		};
	}
}
