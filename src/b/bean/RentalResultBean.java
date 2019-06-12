package b.bean;

public class RentalResultBean {
	private String userId;
	private String bookId;
	//private String rent;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public RentalResultBean(String userId, String bookId) {
		this.userId = userId;
		this.bookId = bookId;
	}
	public RentalResultBean() {
	}
}
