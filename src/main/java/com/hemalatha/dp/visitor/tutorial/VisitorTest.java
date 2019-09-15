package com.hemalatha.dp.visitor.tutorial;

public class VisitorTest {

	public static void main(String[] args) {
		PostageVisitor visitor = new PostageVisitor();

		Book book = new Book();
		book.accept(visitor);

		CD cd = new CD();
		cd.accept(visitor);

		DVD dvd = new DVD();
		dvd.accept(visitor);
	}
}
