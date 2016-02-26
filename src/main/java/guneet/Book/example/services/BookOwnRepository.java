package guneet.Book.example.services;

import java.util.List;

import org.springframework.data.repository.Repository;

import guneet.Book.example.domain.Book;


public interface BookOwnRepository extends Repository<Book, Long>{

	List<Book> findByName(String name);
	List<Book> findByPrice(long price);
	List<Book> findByNameAndAuthor(String name, String author);
	List<Book> findByNameLikeOrAuthorLikeOrPriceGreaterThanEqual(String name,String author, Long price);
}
