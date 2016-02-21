package com.example.services;

import org.springframework.data.repository.CrudRepository;

import com.example.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
