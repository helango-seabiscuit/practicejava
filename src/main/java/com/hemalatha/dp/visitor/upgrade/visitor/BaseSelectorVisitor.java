package com.hemalatha.dp.visitor.upgrade.visitor;

import com.hemalatha.dp.visitor.upgrade.strategy.ProductUpgrade;

public class BaseSelectorVisitor implements ProductTypeVisitor<ProductUpgrade> {
	@Override
	public ProductUpgrade visitPersistent() {
		return null;
	}

	@Override
	public ProductUpgrade visitSubscription() {
		return null;
	}

	@Override
	public ProductUpgrade visitConsumerGift() {
		return null;
	}

	@Override
	public ProductUpgrade visitPaymentBackedCode() {
		return null;
	}

	@Override
	public ProductUpgrade visitThirdPartyGift() {
		return null;
	}

	@Override
	public ProductUpgrade visitAlaCarte() {
		return null;
	}

	@Override
	public ProductUpgrade visitComplimentaryTime() {
		return null;
	}

	@Override
	public ProductUpgrade visitTrialSubscription() {
		return null;
	}
}
