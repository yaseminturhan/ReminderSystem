package implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import interfaces.IDao;
import pojo.StockMarket;
import statics.Global;

public class StockMarketImplementation extends FileProcess implements IDao<StockMarket>{
	
	private static final String FILE_NAME= "stock_market.txt";

	@Override
	public void save(StockMarket stockMarket, String id) {

	}

	@Override
	public void save(StockMarket t) {
		t.setId(super.getLastId(FILE_NAME));
		t.setDate(new Date().toString());
		super.writeFile(FILE_NAME, t.toString());
	}

	@Override
	public void update(String id, StockMarket t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<StockMarket> getAll() {
		ArrayList<StockMarket> stockMarkets =  new ArrayList<>();
		for(String line : super.readLines(FILE_NAME)) {
			String[] attr = line.split("___");
			StockMarket stockMarket = new StockMarket(attr[2], Integer.parseInt(attr[3]), 
					Double.parseDouble(attr[4]), Double.parseDouble(attr[5]), attr[6]);
			stockMarket.setDate(attr[1]);
			stockMarkets.add(stockMarket);
		}
		return stockMarkets;
	}
	
	public ArrayList<ArrayList<String>> getAllForTable() {
		ArrayList<ArrayList<String>> datas = new ArrayList<>();
		for(StockMarket stock :  this.getAll()) {
			if(stock.getUsername().equals(Global.user.getUsername())) {
				ArrayList<String> data = new ArrayList<>();
				data.add(stock.getCompany());
				data.add(String.valueOf(stock.getNumberOfStock()));
				data.add(String.valueOf(stock.getUnitPrice()));
				data.add(String.valueOf(stock.getTotalPrice()));
				data.add(stock.getDate());

				double currentVal = stock.getNumberOfStock() * (new Random().nextInt(34) + 1);
				data.add(String.valueOf(currentVal));

				datas.add(data);
			}

		}
		return datas;
	}

	public double getTotalSpent() {
		double total = 0;
		ArrayList<ArrayList<String>> datas = new ArrayList<>();
		for(StockMarket stock :  this.getAll()) {
			if (stock.getUsername().equals(Global.user.getUsername())) {
				total += stock.getTotalPrice();
			}
		}
		return  total;
	}
	
	public ArrayList<String> getColumnsForTable() {
		ArrayList<String> columns = new ArrayList<>();
		columns.add("Company");
		columns.add("Number Of Stock");
		columns.add("Unit Price");
		columns.add("Total Price");
		columns.add("Date");
		columns.add("Current Value");
		return columns;
	}

}


















