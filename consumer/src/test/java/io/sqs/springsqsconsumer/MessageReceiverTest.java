package io.sqs.springsqsconsumer;

import javassist.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class MessageReceiverTest {

    static Book book;

    static BookRepository bookRepository;

    static MessageReceiver messageReceiver;

    @BeforeAll
    static void beforeAll() {
        book = new Book(1, "testBook", 1.50);
        bookRepository = Mockito.mock(BookRepository.class);
        messageReceiver = new MessageReceiver(bookRepository);
    }

    @Test
    public void receiveMessageFifo_objectExists() throws Throwable {
        Mockito.when(bookRepository.existsById(Mockito.anyInt())).thenReturn(Boolean.TRUE);
        Mockito.when(bookRepository.save(Mockito.any(Book.class))).thenReturn(book);

        Assertions.assertEquals(messageReceiver.receiveMessageFifo(book, 1), book);
    }

    @Test
    public void receiveMessageFifoThrown_objectNotExists() {
        Mockito.when(bookRepository.existsById(Mockito.anyInt())).thenReturn(Boolean.FALSE);
        Mockito.when(bookRepository.save(Mockito.any(Book.class))).thenReturn(book);

        Assertions.assertThrows(NotFoundException.class, () -> messageReceiver.receiveMessageFifo(book, 1));
    }
}
