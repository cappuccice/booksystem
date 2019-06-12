package b.bean;

public class PublisherBean {
	private String publisherCode;
	private String publisherName;

	public PublisherBean(String publisherCode, String publisherName) {
		this.publisherCode = publisherCode;
		this.publisherName = publisherName;
	}

	public PublisherBean() {
	}

	public String getPublisherCode() {
		return publisherCode;
	}

	public void setPublisherCode(String publisherCode) {
		this.publisherCode = publisherCode;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}



}
