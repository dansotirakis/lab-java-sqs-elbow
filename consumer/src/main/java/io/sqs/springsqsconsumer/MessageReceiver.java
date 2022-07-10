package io.sqs.springsqsconsumer;

import io.awspring.cloud.messaging.listener.SqsMessageDeletionPolicy;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import javassist.NotFoundException;
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

	@SqsListener(value = "${cloud.aws.sqs.endpoint}", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
	public Book receiveMessageFifo(Book message, @Header("book-id") int bookId) throws Throwable {
		if (bookRepository.existsById(bookId)) {
			return bookRepository.save(message);
		} else {
			logger.warn("Object not found book id: {}", bookId);
			throw new NotFoundException(String.valueOf(bookId));
		}
	}
}
