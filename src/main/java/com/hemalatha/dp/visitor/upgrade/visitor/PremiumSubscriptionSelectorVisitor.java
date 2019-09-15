package com.hemalatha.dp.visitor.upgrade.visitor;

import com.hemalatha.dp.visitor.upgrade.model.Product;
import com.hemalatha.dp.visitor.upgrade.strategy.PremiumProratedSubscriptionUpgrade;
import com.hemalatha.dp.visitor.upgrade.strategy.PremiumSubscriptionUpgrade;
import com.hemalatha.dp.visitor.upgrade.strategy.ProductUpgrade;

public class PremiumSubscriptionSelectorVisitor extends BaseSelectorVisitor {

	private Product sourceProduct;

	public PremiumSubscriptionSelectorVisitor(Product sourceProduct) {
		this.sourceProduct = sourceProduct;
	}


	@Override
	public ProductUpgrade visitPersistent() {
		return new PremiumSubscriptionUpgrade();
	}

	@Override
	public ProductUpgrade visitSubscription() {
		return new PremiumProratedSubscriptionUpgrade();

		//return new  PremiumSubscriptionUpgrade();
	}

	@Override
	public ProductUpgrade visitConsumerGift() {
		return new PremiumProratedSubscriptionUpgrade();
	}

	@Override
	public ProductUpgrade visitPaymentBackedCode() {
		return new PremiumSubscriptionUpgrade();
	}

	@Override
	public ProductUpgrade visitThirdPartyGift() {
		return new PremiumProratedSubscriptionUpgrade();
	}



	@Override
	public ProductUpgrade visitComplimentaryTime() {
		return new PremiumSubscriptionUpgrade();
	}

	@Override
	public ProductUpgrade visitTrialSubscription() {
		return new PremiumSubscriptionUpgrade();
	}
}
