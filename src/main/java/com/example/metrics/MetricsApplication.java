package com.example.metrics;

import com.example.metrics.entity.clientEntity;
import com.example.metrics.repository.ClientRepository;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
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
		Dotenv dotenv = Dotenv.load();
		String dbPassword = dotenv.get("SPRING_DATASOURCE_PASSWORD");
		System.setProperty("SPRING_DATASOURCE_PASSWORD", dbPassword);

		// Vérification de la valeur
		System.out.println("Database Password: " + dbPassword);
		SpringApplication.run(MetricsApplication.class, args);
	}

	@GetMapping("/mouad")
	public String mouad() {
		return "mouadEee";
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
