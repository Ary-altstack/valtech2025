package com.valtech.training.first.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity

public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="bookSeq")
	@SequenceGenerator(name = "bookSeq",sequenceName = "book_seq",allocationSize = 1)
	private int id;
	private String name;
	private int price;
	private int year;
	
	@ManyToOne(targetEntity = Publisher.class ,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="publisher_id",referencedColumnName = "id")
	private Publisher publisher;
	
	
	@ManyToMany(targetEntity = Author.class ,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(name="book_authors",joinColumns = @JoinColumn(name="book_id"),inverseJoinColumns = @JoinColumn(name="author_id"))
	private List<Author> authors;
//	private Author author;
	

	public Book () {}
	
	public void addAuthor(Author a) {
		if(authors == null) authors = new ArrayList<Author>();
		authors.add(a);
//		if(a.getBooks()==null)a.setBooks(new ArrayList<Author>());
//		a.getBooks().add(this);
	}
	
	public void removeAuthor(Author a) {
		authors.remove(a);
		a.getBooks().remove(this);
	}


	public Book(String name, int price, int year) {
		this.name = name;
		this.price = price;
		this.year = year;
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


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}
	
	public Publisher getPublisher() {
		return publisher;
	}
	
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	
	public List<Author> getAuthor() {
		return authors;
	}
	
	public void setAuthor(List<Author> author) {
		this.authors = author;
	}

}
