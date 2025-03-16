// Task 0: Sort by id
//Task 1: Filter Books by Genre
//Task 2: Apply a Discount to Books
//Task 3: Collect Books by Stock Quantity 
//Task 4: Sort Books by Price
//Task 5: Group Books by Genre
//Task 6: Count Books in Each Genre
//Task 7: Find the Most Expensive Book





package bookStore;



public class Book {
	
	private int id;
	private String name;
	private String genre;
	private String author;
	private int price;
	private int stockQunatity;
	
	
	
	
	public Book(int id, String name, String genre, String author, int price, int stockQunatity) {
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.author = author;
		this.price = price;
		this.stockQunatity = stockQunatity;
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
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStockQunatity() {
		return stockQunatity;
	}
	public void setStockQunatity(int stockQunatity) {
		this.stockQunatity = stockQunatity;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", genre=" + genre + ", author=" + author + ", price=" + price
				+ ", stockQunatity=" + stockQunatity + "]";
	}
	
	public Book() {}
	
	public static BookBuilder builder() {
		return new BookBuilder(new Book());
	}
	
	
	
	public static class BookBuilder{
		private Book book;
		
		public BookBuilder(Book book) {
			this.book=book;
		}
		public Book build() {
			return book;
		}
		
		public BookBuilder id (int id) {
			book.setId(id);
			return this;
		}
		
		public BookBuilder name(String name) {
			book.setName(name);
			return this;
			
		}
			
		public BookBuilder genre(String genre) {
			book.setGenre(genre);
			return this;
		}
		
		
		public BookBuilder author(String author) {
			book.setAuthor(author);
			return this;
		}
		
		public BookBuilder price (int price) {
			book.setPrice(price);
			return this;
		}
		
		
		public BookBuilder stockQuantity (int stockQunatity) {
			book.setStockQunatity(stockQunatity);
			return this;
		}
		
		
	}



	
	
	
	
	

}
