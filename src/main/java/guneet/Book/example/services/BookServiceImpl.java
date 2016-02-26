package guneet.Book.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import guneet.Book.example.domain.Book;


@Service
@Transactional
public class BookServiceImpl implements BookService{
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private BookOwnRepository bookOwnRepository;

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
	public List<Book> findByName(String name) {
		return bookOwnRepository.findByName(name);
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

	public List<Book> findByNameLikeOrAuthorLikeOrPriceGreaterThanEqual(String name, String author, long price){
		return bookOwnRepository.findByNameLikeOrAuthorLikeOrPriceGreaterThanEqual(name, author, price);
	}
	
}