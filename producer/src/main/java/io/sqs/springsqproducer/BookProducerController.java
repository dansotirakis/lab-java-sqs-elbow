package io.sqs.springsqproducer;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@NoArgsConstructor
@AllArgsConstructor
@RequestMapping("/book")
public class BookProducerController {
    @Value("${aws.url.queue}")
    private String QUEUE_NAME_FIFO;

    private MessageSender messageSender;

    private BookRepository bookRepository;

    @PostMapping
    public Book saveBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @GetMapping
    public List<Book> findBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Book> findBook(@PathVariable int id) {
        return bookRepository.findById(id);
    }

    @PutMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String updateBook(@RequestBody Book book) {
        return messageSender.sendBookForUpdate(book, QUEUE_NAME_FIFO) ?
                "Object sent to update" :
                "Object not found and not sent for update";
    }
}
