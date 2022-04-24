package io.sqs.springsqproducer;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookProducerApplicationTests {
	@Value("${aws.url.queue}")
	private String QUEUE_NAME_FIFO;
	private static final Logger logger = LoggerFactory.getLogger(BookProducerApplicationTests.class.getName());
	@Autowired
	private MessageSender messageSender;

	@Test
	void contextLoads() {
	}

	@Test
	void send_message() {
		logger.info("test with message channel.");
		messageSender.sendBookForUpdate(new Book(1,"teste",150.5), QUEUE_NAME_FIFO);
	}
}
