package com.fuseinterns.libraryManagementSystem.book;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book,String> {

    List<Book> findByName (String name);
}
