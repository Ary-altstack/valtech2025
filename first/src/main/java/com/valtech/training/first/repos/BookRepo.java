package com.valtech.training.first.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.valtech.training.dto.BookInfoDTO;
import com.valtech.training.first.entities.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer > {

	List<Book> findAllByYearBetween(int min, int max);
	
	List<Book> findAllByPriceGreaterThan(int price);
	
	List<Book> findAllByAuthorsId(int authorId);
	
	@Query("Select b.price FROM Book b JOIN b.authors a WHERE a.id = ?1")
	List<Book> findAllByPricesByAuthorsId(int id);
	
	@Query("SELECT new com.valtech.training.dto.BookInfoDTO(b.publisher.name,b.price) FROM Book b JOIN b.authors a WHERE a.id = ?1")
	List<BookInfoDTO> getBookInfoByAuthor(int id);
	
}
	// creating the class here for simplicity.Otherwise should be part of another package
	