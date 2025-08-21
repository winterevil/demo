package vn.eiu.edu.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Fmecse4562131200006Application {

	public static void main(String[] args) {
		SpringApplication.run(Fmecse4562131200006Application.class, args);
	}

}
