package com.hemalatha.dp.specification.model;

import com.hemalatha.dp.specification.SearchCriteria;

public class Product {

	private  String gTin;
	private  double price;
	private int units;

	public boolean satisfies(SearchCriteria criteria){
		return criteria.isSatisfiedBy(this);
	}

	public String getgTin() {
		return gTin;
	}

	public void setgTin(String gTin) {
		this.gTin = gTin;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	@Override
	public String toString() {
		return
				"gTin='" + gTin + '\'' +
				", price=" + price +
				", units=" + units ;
	}
}
