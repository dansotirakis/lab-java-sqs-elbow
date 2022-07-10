package io.sqs.springsqsconsumer;

import lombok.Generated;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;


@SpringBootApplication
public class BookConsumerApplication {
	@Generated
	public static void main(String[] args) {
		SpringApplication.run(BookConsumerApplication.class, args);
		System.out.println("cloud.aws.sqs.endpoint");
	}
}
