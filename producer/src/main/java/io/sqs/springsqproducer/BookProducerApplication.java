package io.sqs.springsqproducer;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Component
@RestController
@SpringBootApplication
@RequestMapping("/book")
public class BookProducerApplication {

	@Value("${aws.url.queue}")
	private String QUEUE_NAME_FIFO;
	final MessageSender messageSender;

	private final BookRepository bookRepository;

	public BookProducerApplication(BookRepository bookRepository, MessageSender messageSender) {
		this.bookRepository = bookRepository;
		this.messageSender = messageSender;
	}

	@PostMapping
	public Book saveBook(@RequestBody Book book) {
		return bookRepository.save(book);
	}

	@GetMapping
	public List<Book> findBooks() {
		return bookRepository.findAll();
	}

	@SneakyThrows
	@GetMapping("/{id}")
	public Book findBook(@PathVariable int id) {
		return bookRepository.findById(id).orElseThrow(() -> new Exception("Book not available"));
	}

	@PutMapping
	@ResponseBody
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void updateBook(@RequestBody Book book) {
		messageSender.sendBookForUpdate(book, QUEUE_NAME_FIFO);
	}

	public static void main(String[] args) {
		SpringApplication.run(BookProducerApplication.class, args);
	}

}

