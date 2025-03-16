package bookStore;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BookImpl implements BookService{

	@Override
	public List<Book> sortBookById(List<Book> books) {
		return books.stream().sorted(Comparator.comparingInt(Book::getId)).collect(Collectors.toList());
	}

	@Override
	public List<Book> onlyThriller(List<Book> books) {
		 return books.stream().filter(book -> book.getGenre().contains("Thriller")).collect(Collectors.toList());
	}
	
	@Override
	public List<Book> byStockQuantity(List<Book> books) {
		return books.stream().filter(book -> book.getStockQunatity() <= 500).collect(Collectors.toList());
	}
	
	@Override
	public List<Book> sortBookByPrice(List<Book> books) {
		return books.stream().sorted(Comparator.comparingInt(Book::getPrice)).collect(Collectors.toList());
	}
	
	public Map<String, List<Book>> groupedByGenre(List<Book> books){
	return books.stream().collect(Collectors.groupingBy(Book::getGenre));

	}
	
	
	

	
	
	public static void main(String[] args) {
		
		List<Book> books = new ArrayList<Book>();
		
		books.add(Book.builder().id(1).name("Anxious People").genre("Thriller").author("J.B Hoy").price(1670).stockQuantity(300).build());
		books.add(Book.builder().id(3).name("Normal People").genre("Romance").author("Sally Rooney").price(1000).stockQuantity(600).build());
		books.add(Book.builder().id(9).name("Zero By One").genre("Philosophy").author("J.B Hoy").price(2000).stockQuantity(400).build());
		books.add(Book.builder().id(7).name("Smiling Man").genre("Thriller").author("J.B Hoy").price(1500).stockQuantity(500).build());
		
		
		
		// Sorting books by id
		BookImpl sortedById = new BookImpl();
		List<Book> sortedBooks = sortedById.sortBookById(books);
//		sortedBooks.forEach(System.out::println);
		
		
		
		// Only Thriller books 
		BookImpl bookByGenre = new BookImpl();
		List<Book> thrillerBooks = bookByGenre.onlyThriller(books);
//		thrillerBooks.forEach(System.out::println);
		
		
		
		// Collect a book by the stock Quantity
		BookImpl bookByQuantity = new BookImpl();
		List<Book> byStockQuantity = bookByQuantity.byStockQuantity(books);
//		byStockQuantity.forEach(System.out::println);
		
		
		// SortBooksByPrice
		BookImpl sortByPrice = new BookImpl();
		List<Book> byPrice = sortByPrice.sortBookByPrice(books);
//		byPrice.forEach(System.out::println);
		
//		 Group Books by Genre 

		
//		Map<String, List<Book>> groupedByGenre = books.stream().collect(Collectors.groupingBy(Book::getGenre));
//		System.out.println(groupedByGenre);
		
		BookImpl byGenre = new BookImpl();
		Map<String, List<Book>> genre = byGenre.groupedByGenre(books);
		for (String name: genre.keySet()) {
		    String key = name.toString();
		    String value = genre.get(name).toString();
		    System.out.println(key + " " + value);
		}
		
		
//		Count Books By genre 
		
//		long countBooksByGenre = books.stream().filter(b->b.getGenre()="Thriller").count();
		
	
	}

	

	

	
	

}
