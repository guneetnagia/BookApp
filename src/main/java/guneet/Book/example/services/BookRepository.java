package guneet.Book.example.services;

import org.springframework.data.repository.CrudRepository;

import guneet.Book.example.domain.Book;


public interface BookRepository extends CrudRepository<Book, Long>{

}
