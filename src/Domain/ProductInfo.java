package Domain;

public class ProductInfo {
	private String name;
	private int price;
	private String description;
	private int stock;
	private String category;
	private String img_path;
	public ProductInfo(String name, int price, String description, int stock, String category, String img_path) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.stock = stock;
		this.category = category;
		this.img_path = img_path;
	}
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}
