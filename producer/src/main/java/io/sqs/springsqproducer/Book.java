package io.sqs.springsqproducer;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private double price;
}

