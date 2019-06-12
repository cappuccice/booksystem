package b.bean;

public class NewBookBean {
	private String divCode;
	private String title;
	private String author;
	private String publisherName;
//	private String publicationDate;

	public NewBookBean(String divCode, String title, String author, String publisherName) {
		this.divCode = divCode;
		this.title = title;
		this.author = author;
		this.publisherName = publisherName;
//		this.publicationDate = publicationDate;
	}

	public NewBookBean() {
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
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
//	public String getPublicationDate() {
//		return publicationDate;
//	}
//	public void setPublicationDate(String publicationDate) {
//		this.publicationDate = publicationDate;
//	}

}
