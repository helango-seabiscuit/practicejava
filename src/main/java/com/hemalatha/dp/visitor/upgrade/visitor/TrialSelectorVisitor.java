package com.hemalatha.dp.visitor.upgrade.visitor;

import com.hemalatha.dp.visitor.upgrade.strategy.PlusTrialSubscriptionUpgrade;
import com.hemalatha.dp.visitor.upgrade.strategy.ProductUpgrade;

public class TrialSelectorVisitor extends BaseSelectorVisitor {

	@Override
	public ProductUpgrade visitPersistent() {
		return new PlusTrialSubscriptionUpgrade();
	}
}
