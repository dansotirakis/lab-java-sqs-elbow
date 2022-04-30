package io.sqs.springsqsconsumer;

import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

class BookConsumerApplicationTests {

	private static final Logger logger = LoggerFactory.getLogger(BookConsumerApplicationTests.class.getName());

	public void init() {
		QueueMessagingTemplate messagingTemplate = mock(QueueMessagingTemplate.class);
		MessageReceiver messageReceiver = mock(MessageReceiver.class);
	}

	@Test
	void send_message() {
		logger.info("test with message channel listener.");
	}

}
