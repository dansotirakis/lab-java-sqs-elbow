package io.sqs.springsqsconsumer;

import io.awspring.cloud.messaging.listener.SqsMessageDeletionPolicy;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageReceiver {

	private static final Logger logger = LoggerFactory.getLogger(MessageReceiver.class.getName());
	private final BookRepository bookRepository;

	@SqsListener(value = "${aws.url.queue}", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
	public void receiveMessageFifo(Book message, @Header("book-id") int bookId) {
		if (bookRepository.existsById(bookId)) {
			bookRepository.save(message);
		} else {
			logger.warn("Object not found {}", bookId);
		}
	}
}
