package com.hemalatha.dp.visitor.pandora;

public interface StoreVisitor<T> {

	T visitPaymentTech();

	T visitPaypal();

	T visitApple();

	T visitGoogle();

	T visitAmazon();

	T visitIncomm();

	T visitNone();

	T visitLinkpoint();
}
