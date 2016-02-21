package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Book;
import com.example.domain.BookWrapper;
import com.example.services.BookOwnRepository;
import com.example.services.BookService;

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
	
	@RequestMapping("/add/{name}/{author}/{price}")
	public Book addBook(@PathVariable String name,@PathVariable String author, @PathVariable long price){
		Book book = new Book();
		book.setName(name);
		book.setAuthor(author);
		book.setPrice(price);
		bookService.saveBook(book);
		return book;
	}
	
	@RequestMapping("/delete/{id}")
	public void deleteBook(@PathVariable long id){
		Book book = new Book();
		book.setId(id);
		bookService.delete(id);
	}
	
	@RequestMapping("/search/name/{name}")
	public List<Book> getBookName(@PathVariable String name){
		List<Book> book = bookService.findByNameLike(name);
		return book;
	}
	
	@RequestMapping("/search/author/{author}")
	public List<Book> getBookAuthor(@PathVariable String name){
		List<Book> book = bookService.findByNameLike(name);
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
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public void addNewBook(@RequestBody Book dataBook){
		bookService.saveBook(dataBook);
	}
	
	@RequestMapping(value="/search/filter",method=RequestMethod.POST)
	public List<Book> getFilterBooks(@RequestBody BookWrapper filterItem){
		String title = filterItem.getTitle();
		String author = filterItem.getAuthor();
		Long priceGreater = filterItem.getPriceGreater();
		Long priceLess = filterItem.getPriceLess();
		
		List<Book> bookList=null;
		if(title!=null && author!=null && priceGreater!=null && priceLess!=null)
			bookList = bookService.findByNameLikeAndAuthorLikeAndPriceLessThanEqualAndPriceGreaterThanEqual(title, author, priceLess, priceGreater);
		else if(title!=null || author!=null || priceGreater!=null || priceLess!=null)
			bookList = bookService.findByNameLikeOrAuthorLikeOrPriceLessThanEqualOrPriceGreaterThanEqual(title, author, priceLess, priceGreater);
		System.out.println("Size is : "+bookList.size());
		
		return bookList;
	}
}
