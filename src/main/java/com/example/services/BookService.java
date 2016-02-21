package com.example.services;

import java.util.List;

import com.example.domain.Book;

public interface BookService {

	public List<Book> findAll();
	public void saveBook(Book book);
	public Book findOne(long id);
	public void delete(long id);
	public List<Book> findByName(String name);
	public List<Book> findByNameLike(String name);
	public List<Book> findByPrice(long price);
	public List<Book> findByNameAndAuthor(String name, String author);
	public List<Book> findByAuthor(String author);
	public void updateBook(Book book);
	public List<Book> findByPriceLessThan(long price);
	public List<Book> findByPriceLessThanEqual(long price);
	public List<Book> findByPriceGreaterThan(long price);
	public List<Book> findByPriceGreaterThanEqual(long price);
	public List<Book> findByNameLikeAndAuthorLikeAndPriceLessThanEqualAndPriceGreaterThanEqual(String name,String author,long min,long max);
	public List<Book> findByNameLikeOrAuthorLikeOrPriceLessThanEqualOrPriceGreaterThanEqual(String name,String author,long min,long max);
}
