package io.sqs.springsqproducer;

import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Component
@RestController
@AllArgsConstructor
@RequestMapping("/book")
public class BookProducerController {

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
        return messageSender.sendBookForUpdate(book, System.getenv("QUEUE_URL")) ?
                "Object sent to update" :
                "Object not found and not sent for update";
    }
}
