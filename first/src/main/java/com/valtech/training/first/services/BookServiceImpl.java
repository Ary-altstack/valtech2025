package com.valtech.training.first.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.dto.BookInfoDTO;
import com.valtech.training.first.entities.Book;
import com.valtech.training.first.repos.BookRepo;
//import com.valtech.training.first.repos.BookRepo.BookInfoDTO;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class BookServiceImpl implements BookService   {
	
	@Autowired
	private BookRepo bookRepo;
	
	
	
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}



	@Override
	public Integer countAllAuthors() {
		return null;
	}



	@Override
	public Integer countAllPublishers() {
		return null;
	}



	@Override
	public Integer countAllBooks() {
		return null;
	}



	@Override
	public Integer getBooksByYearBetween(int i, int j) {
		return null;
	}
	
	public List<BookInfoDTO> getBookInfoByAuthor(int id) {
		return bookRepo.getBookInfoByAuthor(id);
	}

	
	
	
	
	
	

}
