package com.hemalatha.dp.visitor.upgrade.selector;

import com.hemalatha.dp.visitor.upgrade.model.Product;
import com.hemalatha.dp.visitor.upgrade.strategy.ProductUpgrade;

public class BaseUpgradeSelector implements ProductUpgradeSelector {
	@Override
	public ProductUpgrade getUpgradeFrom(Product sourceProduct) {
		return null;
	}


}
