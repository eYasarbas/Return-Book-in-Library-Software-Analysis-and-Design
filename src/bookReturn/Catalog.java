package bookReturn;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
	
	public Catalog() {
	}

	List<Book> books=new ArrayList<>();

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public List<Book> addBooks(Book book) {
		books.add(book);
		setBooks(books);
		return books;
	}

	@Override
	public String toString() {
		return "Catalog [books=" + books + "]";
	}

	public Book searchBook(String id) {
		Book book = books.stream().filter(b -> b.getId().equals(id)).findAny().orElse(null);
		if (book != null) {
			return book;

		}
		return null;

	}


}
