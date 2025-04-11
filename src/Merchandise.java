package haditech;

public class Merchandise {
	private String name, category;
	private int total, sold, id;
	private double unit_price, price;

	public Merchandise(String name, int total, int sold, String category, double price, int id, double unit_price) {
		this.name = name;
		this.total = total;
		this.sold = sold;
		this.price = price;
		this.category = category;
		this.id = id;
		this.unit_price = unit_price;
	}

	public String getName() {
		return name;
	}

	public int getTotal() {
		return total;
	}

	public int getSold() {
		return sold;
	}

	public String getCategory() {
		return category;
	}

	public double getPrice() {
		return price;
	}

	public double getUnitPrice() {
		return unit_price;
	}

	public int getID() {
		return id;
	}
}