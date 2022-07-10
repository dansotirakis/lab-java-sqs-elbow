package io.sqs.springsqproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class BookProducerApplication {
	public static void main(String[] args) {
		SpringApplication.run(BookProducerApplication.class, args);
	}

}

