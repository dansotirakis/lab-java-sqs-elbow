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
	private static final Logger log = LoggerFactory.getLogger(MessageSender.class);

	private final QueueMessagingTemplate messagingTemplate;

	private final BookRepository bookRepository;
	public void sendBookForUpdate(final Book messageObject, String queue) {
		if (bookRepository.existsById(messageObject.getId())) {
			Map<String, Object> headers = buildingHeaders(messageObject);
			messagingTemplate.convertAndSend(queue, messageObject, headers);
		} else {
			log.warn("Object Not Found");
		}
	}

	private Map<String, Object> buildingHeaders(Book messageObject) {
		Map<String, Object> headers = new HashMap<>();
		headers.put("message-group-id", UUID.randomUUID().toString());
		headers.put("message-deduplication-id", UUID.randomUUID().toString());
		headers.put("book-id", messageObject.getId());
		return headers;
	}

}
