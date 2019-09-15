package com.hemalatha.dp.visitor.upgrade.visitor;

import com.hemalatha.dp.visitor.upgrade.strategy.ProductUpgrade;

public class PremiumTrialSelectorVisitor extends BaseSelectorVisitor {
	@Override
	public ProductUpgrade visitPersistent() {
		return super.visitPersistent();
	}

	@Override
	public ProductUpgrade visitSubscription() {
		return super.visitSubscription();
	}

	@Override
	public ProductUpgrade visitConsumerGift() {
		return super.visitConsumerGift();
	}

	@Override
	public ProductUpgrade visitPaymentBackedCode() {
		return super.visitPaymentBackedCode();
	}

	@Override
	public ProductUpgrade visitThirdPartyGift() {
		return super.visitThirdPartyGift();
	}

	@Override
	public ProductUpgrade visitAlaCarte() {
		return super.visitAlaCarte();
	}

	@Override
	public ProductUpgrade visitComplimentaryTime() {
		return super.visitComplimentaryTime();
	}

	@Override
	public ProductUpgrade visitTrialSubscription() {
		return super.visitTrialSubscription();
	}
}
