package com.fuseinterns.libraryManagementSystem.book;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book,String> {

    public List<Book> findByName (String name);
    public Book findByBookId(String id);
}
