package io.sqs.springsqsconsumer;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookProducerApplicationTests {
	@Value("${aws.url.queue}")
	private String QUEUE_NAME_FIFO;
	private static final Logger logger = LoggerFactory.getLogger(BookProducerApplicationTests.class.getName());

	@Test
	void contextLoads() {
	}

	@Test
	void send_message() {
		logger.info("test with message channel listener.");
	}
}
