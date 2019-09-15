package com.hemalatha.dp.visitor.tutorial;

public class PostageVisitor implements  Visitor {
	@Override
	public void visit(Book book) {
		System.out.println("Visited book");
	}

	@Override
	public void visit(CD cd) {
		System.out.println("Visited CD");
	}

	@Override
	public void visit(DVD dvd) {
		System.out.println("Visited DVD");
	}
}
