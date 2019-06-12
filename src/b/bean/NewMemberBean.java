package b.bean;

import java.sql.Date;

public class NewMemberBean {

	private String userName;
	private String postal;
	private String address;
	private String tel;
	private String email;
	private Date birthday;

	public NewMemberBean() {
	}

	public NewMemberBean(String userName, String postal, String address,
			String tel, String email, Date birthday) {
		this.userName = userName;
		this.postal = postal;
		this.address = address;
		this.tel = tel;
		this.email = email;
		this.birthday = birthday;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}




}
