package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.domain.Book;

@Service
@Transactional
public class BookServiceImpl implements BookService{
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private BookOwnRepository bookOwnRepository;

	@Autowired
	private BookCustomRepository bookCustomRepository;
	
	@Override
	public List<Book> findAll() {
		return (List<Book>) bookRepository.findAll();
	}

	@Override
	public void saveBook(Book book) {
		bookRepository.save(book);
	}

	@Override
	public Book findOne(long id) {
		return bookRepository.findOne(id);
	}

	@Override
	public void delete(long id) {
		bookRepository.delete(id);
	}

	@Override
	public List<Book> findByNameLike(String name) {
		return bookOwnRepository.findByNameLike(name);
	}

	@Override
	public List<Book> findByPrice(long price) {
		return bookOwnRepository.findByPrice(price);
	}

	@Override
	public List<Book> findByNameAndAuthor(String name, String author) {
		return bookOwnRepository.findByNameAndAuthor(name, author);
	}

	@Override
	public void updateBook(Book book) {
		bookRepository.save(book);
	}

	@Override
	public List<Book> findByAuthor(String author) {
		return bookOwnRepository.findByAuthor(author);
	}

	@Override
	public List<Book> findByPriceLessThan(long price) {
		return bookCustomRepository.findByPriceLessThan(price);
	}

	@Override
	public List<Book> findByPriceLessThanEqual(long price) {
		return bookCustomRepository.findByPriceLessThanEqual(price);
	}

	@Override
	public List<Book> findByPriceGreaterThan(long price) {
		return bookCustomRepository.findByPriceGreaterThan(price);
	}

	@Override
	public List<Book> findByPriceGreaterThanEqual(long price) {
		return bookCustomRepository.findByPriceGreaterThanEqual(price);
	}

	@Override
	public List<Book> findByName(String name) {
		return bookOwnRepository.findByName(name);
	}
	
	@Override
	public List<Book> findByNameLikeAndAuthorLikeAndPriceLessThanEqualAndPriceGreaterThanEqual(String name,String author,long min,long max){
		return bookCustomRepository.findByNameLikeAndAuthorLikeAndPriceLessThanEqualAndPriceGreaterThanEqual(name,author,min,max);
	}
	
	@Override
	public List<Book> findByNameLikeOrAuthorLikeOrPriceLessThanEqualOrPriceGreaterThanEqual(String name,String author,long min,long max){
		return bookCustomRepository.findByNameLikeOrAuthorLikeOrPriceLessThanEqualOrPriceGreaterThanEqual(name,author,min,max);
	}
	
}
