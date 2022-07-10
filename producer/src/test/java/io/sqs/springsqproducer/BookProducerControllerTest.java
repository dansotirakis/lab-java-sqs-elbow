package io.sqs.springsqproducer;

import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

class BookProducerControllerTest {

    private static final String QUEUE_NAME_FIFO = System.getenv("${aws.url.queue}");

    static Book book;

    static ArrayList<Book> books = new ArrayList<>();

    static MessageSender messageSender;

    static BookRepository bookRepository;

    static QueueMessagingTemplate messagingTemplate;

    static BookProducerController bookProducerController;

    @BeforeEach
    void setUp() {
        book = new Book(1, "testBook", 1.50);
        books.add(book);
        bookRepository = Mockito.mock(BookRepository.class);
        messagingTemplate = Mockito.mock(QueueMessagingTemplate.class);
        messageSender = new MessageSender(messagingTemplate, bookRepository);
        Mockito.when(bookRepository.save(book)).thenReturn(book);
        Mockito.when(bookRepository.findAll()).thenReturn(books);
        Mockito.when(bookRepository.findById(any(Integer.class))).thenReturn(Optional.ofNullable(book));
        bookProducerController = new BookProducerController(messageSender, bookRepository);
    }

    @Test
    void saveBook() {
        Assertions.assertEquals(bookProducerController.saveBook(book), book);
    }

    @Test
    void findBooks() {
        Assertions.assertEquals(bookProducerController.findBooks(), books);
    }

    @Test
    void findBook() {
        Assertions.assertTrue(bookProducerController.findBook(any(Integer.class)).isPresent());
    }

    @Test
    void updateBook() {
        Mockito.when(bookRepository.existsById(Mockito.anyInt())).thenReturn(Boolean.TRUE);
        Assertions.assertEquals(bookProducerController.updateBook(book), "Object sent to update");
    }

    @Test
    void updateBook_notFoundObject() {
        Mockito.when(bookRepository.existsById(Mockito.anyInt())).thenReturn(Boolean.FALSE);
        Assertions.assertEquals(bookProducerController.updateBook(book), "Object not found and not sent for update");
    }
}
