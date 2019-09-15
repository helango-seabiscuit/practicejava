package com.hemalatha.dp.visitor.tutorial;

public class DVD implements Visitable {
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
