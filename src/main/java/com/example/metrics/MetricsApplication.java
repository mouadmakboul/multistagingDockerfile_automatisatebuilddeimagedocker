package com.example.metrics;

import com.example.metrics.entity.clientEntity;
import com.example.metrics.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MetricsApplication {
	private final ClientRepository clientRepository;

	public MetricsApplication(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MetricsApplication.class, args);


		// Vérifier le nombre d'instances du bean ClientRepository
		String[] beanNames = context.getBeanNamesForType(ClientRepository.class);
		System.out.println("Nombre d'instances de ClientRepository : " + beanNames.length);

		for (String beanName : beanNames) {
			System.out.println("Bean Nameeeeee: " + beanName);
			System.out.println("Is Singleton: " + context.isSingleton(beanName));
		}
	}

	@GetMapping("/mouad")
	public String mouad() {
		return "mouadEeee";
	}

	@Bean
	public CommandLineRunner run() {
		return args -> {
			clientEntity client1 = new clientEntity("Client1121", "Adresse1");
			clientEntity client2 = new clientEntity("Client2222", "Adresse2");

			clientRepository.save(client1);
			clientRepository.save(client2);
		};
	}
}
