package io.sqs.springsqproducer;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class MessageSenderTest {

    private static final String QUEUE_NAME_FIFO = "example.fifo";

    static MessageSender messageSender;

    static Book book;

    static BookRepository bookRepository;

    static QueueMessagingTemplate messagingTemplate;

    static AmazonSQSAsync amazonSQSAsync;

    @BeforeAll
    static void setUp() {
        book = new Book(1, "testBook", 1.50);
        bookRepository = Mockito.mock(BookRepository.class);
        amazonSQSAsync = Mockito.mock(AmazonSQSAsync.class);
        messagingTemplate = Mockito.mock(QueueMessagingTemplate.class);
        messageSender = new MessageSender(messagingTemplate, bookRepository);
    }

    @Test
    void sendBookForUpdate_buildHeaders() {
        Mockito.when(bookRepository.existsById(Mockito.anyInt())).thenReturn(Boolean.TRUE);

        Assertions.assertTrue(messageSender.buildingHeaders(book).containsValue(book.getId()));
    }

    @Test
    void sendBookForUpdate_objectExists() {
        Mockito.when(bookRepository.existsById(Mockito.anyInt())).thenReturn(Boolean.TRUE);

        Assertions.assertTrue(messageSender.sendBookForUpdate(book, QUEUE_NAME_FIFO));
    }

    @Test
    public void receiveMessageFifoThrown_objectNotExists() {
        Mockito.when(bookRepository.existsById(Mockito.anyInt())).thenReturn(Boolean.FALSE);

        Assertions.assertFalse(() -> messageSender.sendBookForUpdate(book, QUEUE_NAME_FIFO));
    }
}
