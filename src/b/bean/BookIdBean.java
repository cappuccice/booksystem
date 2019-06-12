package b.bean;

public class BookIdBean {
	private String bookId;
	private String bookIsbn;

	public BookIdBean(String bookId, String bookIsbn) {
		this.bookId = bookId;
		this.bookIsbn = bookIsbn;
	}

	public BookIdBean() {
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookIsbn() {
		return bookIsbn;
	}

	public void setBookIsbn(String bookIsbn) {
		this.bookIsbn = bookIsbn;
	}

}
