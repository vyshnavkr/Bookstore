package bookstore;

public class Book {
	private int id;
	private String title;
	private String author;
	private float price;

	public Book() {
	}
	
	public Book(int id) {
		this.id = id;
	}
	
	public Book(String title, String author, float price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}
	public Book(int id, String title, String author, float price) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
}
