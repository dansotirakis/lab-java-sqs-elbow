package com.example.workflow.clients;

import com.example.workflow.domain.Book.Book;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "books", url = "${book.api.url}")
public interface BookProducerClient {

    @PostMapping(path = "/book")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Book newBook(@RequestBody Book book);

    @RequestMapping(path = "/book/{id}", method = RequestMethod.GET)
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Book finBook(@PathVariable(value = "id") int id);
}
