package b.java;

import java.util.ArrayList;

public class ValidationErrors {

	private ArrayList<ValidationError> errors = new ArrayList<ValidationError>() ;

	public ValidationErrors() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public void  add(ValidationError e) {
		errors.add(e);
	}

	public int getSize() {
		return errors.size();
	}

	public ArrayList<ValidationError>  getList() {
		return errors;
	}
}
