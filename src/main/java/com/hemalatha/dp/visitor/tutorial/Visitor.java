package com.hemalatha.dp.visitor.tutorial;

public interface Visitor {
	void visit(Book book);
	void visit(CD cd);
	void visit(DVD dvd);
}
