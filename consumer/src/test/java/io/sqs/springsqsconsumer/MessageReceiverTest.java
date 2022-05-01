package io.sqs.springsqsconsumer;

import javassist.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


class MessageReceiverTest {

    static Book book;
    @BeforeAll
    static void beforeAll() {
        book = new Book(1, "testBook", 1.50);
    }

    @Test
    public void receiveMessageFifo_objectExists() throws Throwable {
        BookRepository bookRepository = Mockito.mock(BookRepository.class);
        Mockito.when(bookRepository.existsById(Mockito.anyInt())).thenReturn(Boolean.TRUE);
        Mockito.when(bookRepository.save(Mockito.any(Book.class))).thenReturn(book);
        MessageReceiver messageReceiver = new MessageReceiver(bookRepository);

        Assertions.assertEquals(messageReceiver.receiveMessageFifo(book,1), book);
    }

    @Test
    public void receiveMessageFifoThrown_objectNotExists() {
        BookRepository bookRepository = Mockito.mock(BookRepository.class);
        Mockito.when(bookRepository.existsById(Mockito.anyInt())).thenReturn(Boolean.FALSE);
        Mockito.when(bookRepository.save(Mockito.any(Book.class))).thenReturn(book);
        MessageReceiver messageReceiver = new MessageReceiver(bookRepository);
        Assertions.assertThrows(NotFoundException.class, () -> messageReceiver.receiveMessageFifo(book,1));
    }
}
