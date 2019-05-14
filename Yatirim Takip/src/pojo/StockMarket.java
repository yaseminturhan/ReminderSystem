package pojo;

import java.util.Date;

public class StockMarket extends Entity{

	private String company;
	private int numberOfStock;
	private double unitPrice;
	private double totalPrice;
	private String username;
	
	public StockMarket(String company, int numberOfStock, double unitPrice, double totalPrice, String username) {
		super();
		this.company = company;
		this.numberOfStock = numberOfStock;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
		this.username = username;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getNumberOfStock() {
		return numberOfStock;
	}

	public void setNumberOfStock(int numberOfStock) {
		this.numberOfStock = numberOfStock;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return super.toString() + company + "___" + numberOfStock + "___" + unitPrice + "___" + totalPrice + "___" + username;
	}
	
	
	
}
