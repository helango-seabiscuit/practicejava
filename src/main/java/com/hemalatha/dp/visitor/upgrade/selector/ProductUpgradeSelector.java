package com.hemalatha.dp.visitor.upgrade.selector;

import com.hemalatha.dp.visitor.upgrade.model.Product;
import com.hemalatha.dp.visitor.upgrade.strategy.ProductUpgrade;

@FunctionalInterface
public interface ProductUpgradeSelector  {


	ProductUpgrade getUpgradeFrom(Product sourceProduct);
}
