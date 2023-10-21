package ie.atu.week5blockingapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class Week5blockingapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(Week5blockingapplicationApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){return new RestTemplate();}

}
