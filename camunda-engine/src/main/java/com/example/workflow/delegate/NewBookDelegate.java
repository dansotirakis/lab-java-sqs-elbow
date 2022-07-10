package com.example.workflow.delegate;

import com.example.workflow.clients.BookProducerClient;
import com.example.workflow.domain.Book.Book;
import lombok.AllArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component("newBookDelegate")
public class NewBookDelegate implements JavaDelegate {

    private BookProducerClient bookProducerClient;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Book book = new Book();
        book.setName((String) delegateExecution.getVariable("book_name"));
        book.setPrice((double) delegateExecution.getVariable("book_price"));
        Book newBook = bookProducerClient.newBook(book);
        delegateExecution.setVariable("book_id", newBook.getId());
    }
}
