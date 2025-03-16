package bookStore;

import java.util.List;

public interface BookService {

	public List<Book> sortBookById(List<Book> books);
	public List<Book> onlyThriller(List<Book> books);
	public List<Book> byStockQuantity(List<Book> books);
	public List<Book> sortBookByPrice(List<Book> books);
//	public List<Book> groupBooksByGenre(List<Book> books);

}