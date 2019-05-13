package co.pruebatecnica.masivian.users;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import co.pruebatecnica.masivian.users.client.entities.User;
import co.pruebatecnica.masivian.users.client.service.UserService;

@SpringBootApplication
public class UsersApplication {
	
	private static final Logger log = LogManager.getLogger(UsersApplication.class);
	
	@Value("${masivian.rest.url}")
	private String url;

	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate, UserService userService) throws Exception {
		return args -> {
			ResponseEntity<List<User>> rateResponse = restTemplate.exchange(
					url,HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
		            });
			List<User> userParsingFromJASON = rateResponse.getBody();
			
			for (User userToStoreOnDB : userParsingFromJASON)
				userService.saveOrUpdate(userToStoreOnDB);
			
			for (User userQueryedToDB : userService.getAllResultadoOperacion())
				log.info(userQueryedToDB);
		};
	}

}
