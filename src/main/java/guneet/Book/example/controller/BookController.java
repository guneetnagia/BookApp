package guneet.Book.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import guneet.Book.example.domain.Book;
import guneet.Book.example.services.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bookService;

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	

	@RequestMapping("/delete/{id}")
	public void deleteBook(@PathVariable long id){
		Book book = new Book();
		book.setId(id);
		bookService.delete(id);
	}
	
	@RequestMapping("/search/name/{name}")
	public List<Book> getBookName(@PathVariable String name){
		List<Book> book = bookService.findByName(name);
		return book;
	}
	
	@RequestMapping("/search/price/{price}")
	public List<Book> getBookPrice(@PathVariable long price)
	{
		List<Book> book = bookService.findByPrice(price);
		return book;
	}
	
	@RequestMapping("/search/{name}/{author}")
	public List<Book> getBookNameAuthor(@PathVariable String name,@PathVariable String author){
		List<Book> book = bookService.findByNameAndAuthor(name, author);
		return book;
	}
	
	@RequestMapping("/search/id/{id}")
	public Book getBook(@PathVariable long id){
		Book book = bookService.findOne(id);
		return book;
	}
	
	@RequestMapping("/search")
	public List<Book> getAllBook(){
		List<Book> book = bookService.findAll();
		return book;
	}
	
	@RequestMapping(value="/edit/{bookId}/{bookName}/{bookAuthor}/{bookPrice}", method=RequestMethod.PUT)
	public String editBookDetails(@PathVariable long bookId,@PathVariable String bookName,@PathVariable String bookAuthor,@PathVariable long bookPrice){
		
		Book book = new Book();
		book.setId(bookId);
		book.setName(bookName);
		book.setAuthor(bookAuthor);
		book.setPrice(bookPrice);
		
		if(getBook(bookId)!=null){
			bookService.updateBook(book);
		}
		else{
			return "Book Does not exist!";
		}
		return "success";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public void addNewBook(@RequestBody Book book){
		bookService.saveBook(book);
	}
	
	@RequestMapping(value="/filterSearch")
	public void filterSearchBooks(@RequestBody Book book){
		
	}
}
