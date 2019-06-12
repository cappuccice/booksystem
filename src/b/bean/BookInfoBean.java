package b.bean;

import b.java.Book;

public class BookInfoBean {
	private String publisherName;
	private String bookId;
	private Book book;
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public BookInfoBean() {}
	public BookInfoBean(String publisherName, String bookId, Book book) {
		this.publisherName = publisherName;
		this.bookId = bookId;
		this.book = book;
	}

}
