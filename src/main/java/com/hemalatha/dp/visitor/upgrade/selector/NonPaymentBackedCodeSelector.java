package com.hemalatha.dp.visitor.upgrade.selector;

import com.hemalatha.dp.visitor.upgrade.model.Product;
import com.hemalatha.dp.visitor.upgrade.strategy.ConsumerGiftUpgrade;
import com.hemalatha.dp.visitor.upgrade.strategy.NonPaymentBackedCodeUpgrade;
import com.hemalatha.dp.visitor.upgrade.strategy.ProductUpgrade;

public class NonPaymentBackedCodeSelector extends BaseUpgradeSelector{

	@Override
	public ProductUpgrade getUpgradeFrom(Product sourceProduct) {
		return new NonPaymentBackedCodeUpgrade();
	}
}
