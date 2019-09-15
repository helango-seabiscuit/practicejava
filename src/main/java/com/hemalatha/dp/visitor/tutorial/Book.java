package com.hemalatha.dp.visitor.tutorial;

public class Book implements Visitable {

	private double price;
	private double weight;

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
}
