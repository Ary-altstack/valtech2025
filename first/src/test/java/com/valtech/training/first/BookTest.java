package com.valtech.training.first;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.first.entities.Book;
import com.valtech.training.first.services.BookService;

@SpringBootTest
public class BookTest {
	
	@Autowired
	private BookService bookService;
	
	
	@Test
	void testBookService() {
//		assertEquals(6, bookService.getAllBooks().size());
//		assertEquals(3, bookService.countAllPublishers());
//		assertEquals(6, bookService.countAllBooks());
//		assertEquals(6,bookService.countAllAuthors());
//		assertEquals(5,bookService.getBooksByYearBetween(2000,2006)).size();
//		assertEquals(3, bookService,findAllPricesByAuthorsId(1).size());
//		assertEquals(5,bookService.getBookInfo)
		System.out.println(bookService.getBookInfoByAuthor(2));
		
		
	}


	private List<Book> findAllPricesByAuthorsId(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
