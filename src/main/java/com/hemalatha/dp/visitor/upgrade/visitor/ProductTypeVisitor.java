package com.hemalatha.dp.visitor.upgrade.visitor;

public interface ProductTypeVisitor<T> {

	T visitPersistent();

	T visitSubscription();

	T visitConsumerGift();

	T visitPaymentBackedCode();

	T visitThirdPartyGift();

	T visitAlaCarte();

	T visitComplimentaryTime();

	T visitTrialSubscription();
}
