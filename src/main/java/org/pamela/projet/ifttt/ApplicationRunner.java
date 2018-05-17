package org.pamela.projet.ifttt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@ComponentScan("org.pamela.projet")
public class ApplicationRunner {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationRunner.class);

	public static void main(String[] args) {


		SpringApplication.run(ApplicationRunner.class);

	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		RestTemplate template = builder.build();
		LOGGER.info("------------- Création du RestTemplate {}, {}", template, "coucou");
		return template;

	}

//	@Bean
//	public CommandLineRunner run(RestTemplate restTemplate) {
//		LOGGER.info("------------- Utilisation du RestTemplate {}", restTemplate);
//		return args -> {
//			Livre livre = restTemplate.getForObject("http://localhost:8080/rest-ws/api/book/1", Livre.class);
//			LOGGER.info(livre.toString());
//		};
//	}

}
