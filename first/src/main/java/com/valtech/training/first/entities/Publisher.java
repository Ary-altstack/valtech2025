package com.valtech.training.first.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Publisher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="publisherSeq")
	@SequenceGenerator(name = "publisher_seq",sequenceName = "pub_seq",allocationSize = 1)
	private int id;
	private String name;
	
	@OneToMany(targetEntity = Book.class, mappedBy="publisher",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Book> books;
	
	
	public Publisher () {}
	
	public void addBook(Book book) {
		if(books==null) books = new ArrayList<Book>();
		books.add(book);
		book.setPublisher(this);
	}
	
	public void removeBook (Book book) {
		books.remove(book);
		book.setPublisher(this);
	}
	
	public Publisher(String name) {
		
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	public List<Book> getBooks() {
		return books;
	}
	
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
	
	

}
