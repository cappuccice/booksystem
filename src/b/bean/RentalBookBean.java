package b.bean;

import java.io.Serializable;
import java.util.List;

public class RentalBookBean implements Serializable{
	private String userId;
	private List<String> bookStateId;
	public List<String> getBookStateId() {
		return bookStateId;
	}

	public void setBookStateId(String hoge) {
		bookStateId.add(hoge);
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}


	public RentalBookBean() {

	}

	public RentalBookBean(String userId,List<String> bookStateId) {
		this.userId = userId;
		this.bookStateId = bookStateId;
	}



}
