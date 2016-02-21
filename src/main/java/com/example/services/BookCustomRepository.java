package com.example.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.Book;

public interface BookCustomRepository extends JpaRepository<Book, Long>{
	
	// Get all Books with price less than
	List<Book> findByPriceLessThan(long price);
	
	// Get all books with price less than equals
	List<Book> findByPriceLessThanEqual(long price);
	
	//Get all Books with price greater than
	List<Book> findByPriceGreaterThan(long price);
	
	//Get all Books with price Greater than Equal
	List<Book> findByPriceGreaterThanEqual(long price); 
	
	List<Book> findByNameLikeOrAuthorLikeOrPriceLessThanEqualOrPriceGreaterThanEqual(String name,String author,long min,long max);
	
	List<Book> findByNameLikeAndAuthorLikeAndPriceLessThanEqualAndPriceGreaterThanEqual(String name,String author,long min,long max);
	
}
