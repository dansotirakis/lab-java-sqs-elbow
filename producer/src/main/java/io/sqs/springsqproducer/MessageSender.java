package io.sqs.springsqproducer;

import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MessageSender {

	private static final Logger logger = LoggerFactory.getLogger(MessageSender.class.getName());

	private final QueueMessagingTemplate messagingTemplate;

	private final BookRepository bookRepository;

	public Boolean sendBookForUpdate(final Book messageObject, String queue) {
		if (bookRepository.existsById(messageObject.getId())) {
			messagingTemplate.convertAndSend(queue, messageObject, buildingHeaders(messageObject));
			return true;
		} else {
			logger.warn("Object Not Found {}", messageObject.getId());
			return Boolean.FALSE;
		}
	}

	public Map<String, Object> buildingHeaders(Book messageObject) {
		Map<String, Object> headers = new HashMap<>();
		headers.put("message-group-id", UUID.randomUUID().toString());
		headers.put("message-deduplication-id", UUID.randomUUID().toString());
		headers.put("book-id", messageObject.getId());
		return headers;
	}

}
