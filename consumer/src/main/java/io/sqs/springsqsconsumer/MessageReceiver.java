package io.sqs.springsqsconsumer;

import io.awspring.cloud.messaging.listener.SqsMessageDeletionPolicy;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import io.sqs.springsqsconsumer.BookRepository;
import io.sqs.springsqsconsumer.Book;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class MessageReceiver {
	private final BookRepository bookRepository;

	@SqsListener(value = "elbow.fifo", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
	public void receiveMessageFifo(Book message, @Header("book-id") int bookId) {
		if (bookRepository.existsById(bookId)) {
			bookRepository.save(message);
		} else {
			log.warn("Error received message");
		}
	}

}
