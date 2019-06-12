package b.java;

public class Member {
	private String userId;
	private String userName;
	private String address;
	private String tel;
	private String email;

//	 DAO用追加分
	private String postal;
	private String birthday;


	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getPostal() {
		return postal;
	}
	public void setPostal(String postal) {
		this.postal = postal;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public Member() {}

    public Member(String userId, String userName, String address,
    		String tel, String email, String postal, String birthday) {
    	this.userId = userId;
    	this.userName = userName;
    	this.address = address;
    	this.tel = tel;
    	this.email = email;
    	this.postal = postal;
    	this.birthday = birthday;
    }

}

