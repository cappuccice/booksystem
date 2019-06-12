package b.java;

public class Book {
	//private String bookId;
	private String isbn;
	private String divCode;
	private String title;
	private String author;
	private String publisher;
	//private String publicationDate;



//	public String getBookId() {
//		return bookId;
//	}
//
//	public void setBookId(String bookId) {
//		this.bookId = bookId;
//	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getDivCode() {
		return divCode;
	}
	public void setDivCode(String divCode) {
		this.divCode = divCode;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
//	public String getPublicationdate() {
//		return publicationDate;
//	}
//	public void setPublicationDate(String publicationDate) {
//		this.publicationDate = publicationDate;
//	}
	public Book(String isbn, String divCode, String title, String author, String publisher) {
		//this.bookId = bookId;
		this.isbn = isbn;
		this.divCode = divCode;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		//this.publicationDate = publicationDate;
	}
}
