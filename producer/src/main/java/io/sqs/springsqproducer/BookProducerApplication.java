package io.sqs.springsqproducer;

import javassist.NotFoundException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Component

@SpringBootApplication

public class BookProducerApplication {
	public static void main(String[] args) {
		SpringApplication.run(BookProducerApplication.class, args);
	}

}

