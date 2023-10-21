package ie.atu.week5blockingapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Week5blockingapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(Week5blockingapplicationApplication.class, args);
	}

}
