package com.example.services;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.domain.Book;

public interface BookOwnRepository extends Repository<Book, Long>{

	List<Book> findByNameLike(String name);
	List<Book> findByPrice(long price);
	List<Book> findByNameAndAuthor(String name, String author);
	List<Book> findByAuthor(String author);
	List<Book> findByName(String name);
}
