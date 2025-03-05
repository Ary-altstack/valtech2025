package com.valtech.training.first.services;

import java.util.List;

import com.valtech.training.dto.BookInfoDTO;
import com.valtech.training.first.entities.Book;
import com.valtech.training.first.entities.Question;
//import com.valtech.training.first.repos.BookRepo.BookInfoDTO;

public interface BookService {
	
	List<Book>getAllBooks();

	Integer countAllAuthors();

	Integer countAllPublishers();

	Integer countAllBooks();

	Integer getBooksByYearBetween(int i, int j);

//	String getBookInfoByAuthor(int i);
	
	List<BookInfoDTO> getBookInfoByAuthor(int id);

	
	
	
	
	
	
	
	
	
	


}
