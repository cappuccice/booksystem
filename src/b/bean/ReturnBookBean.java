package b.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ReturnBookBean implements Serializable{
	private List<String> bookStateId = new ArrayList<>();

	public List<String> getBookStateId() {
		return bookStateId;
	}

	public void setBookStateId(String hoge) {
		bookStateId.add(hoge);

	}


	public ReturnBookBean() {
	}

	public ReturnBookBean(List<String> bookStateId) {
		this.bookStateId = bookStateId;

	}



}
