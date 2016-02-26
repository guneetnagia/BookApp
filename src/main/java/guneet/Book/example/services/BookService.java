package guneet.Book.example.services;

import java.util.List;

import guneet.Book.example.domain.Book;

public interface BookService {

	public List<Book> findAll();
	public void saveBook(Book book);
	public Book findOne(long id);
	public void delete(long id);
	public List<Book> findByName(String name);
	public List<Book> findByPrice(long price);
	public List<Book> findByNameAndAuthor(String name, String author);
	public void updateBook(Book book);
	public List<Book> findByNameLikeOrAuthorLikeOrPriceGreaterThanEqual(String name, String author, long price);
}