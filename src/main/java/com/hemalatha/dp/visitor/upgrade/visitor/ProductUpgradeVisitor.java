package com.hemalatha.dp.visitor.upgrade.visitor;

import com.hemalatha.dp.visitor.upgrade.model.Product;
import com.hemalatha.dp.visitor.upgrade.selector.BaseUpgradeSelector;
import com.hemalatha.dp.visitor.upgrade.selector.ComplimentarySubscriptionSelector;
import com.hemalatha.dp.visitor.upgrade.selector.ConsumerGiftSelector;
import com.hemalatha.dp.visitor.upgrade.selector.PaymentBackedCodeSelector;
import com.hemalatha.dp.visitor.upgrade.selector.PlustrialUpgradeSelector;
import com.hemalatha.dp.visitor.upgrade.selector.PremiumSubscriptionUpgradeSelector;
import com.hemalatha.dp.visitor.upgrade.selector.PremiumTrialUpgradeSelector;
import com.hemalatha.dp.visitor.upgrade.selector.ProductUpgradeSelector;
import com.hemalatha.dp.visitor.upgrade.strategy.ConsumerGiftUpgrade;
import com.hemalatha.dp.visitor.upgrade.strategy.SubscriptionUpgrade;

public class ProductUpgradeVisitor implements ProductTypeVisitor<ProductUpgradeSelector> {

	private Product destinationProduct;

	public ProductUpgradeVisitor(Product destinationProduct) {
		this.destinationProduct = destinationProduct;
	}


	@Override
	public ProductUpgradeSelector visitPersistent() {
		return  new BaseUpgradeSelector();
	}

	@Override
	public ProductUpgradeSelector visitSubscription() {
		if(destinationProductIsPremium()){
			return new PremiumSubscriptionUpgradeSelector();
		}

		return (sourceProduct) -> new SubscriptionUpgrade();
	}

	private boolean destinationProductIsPremium() {
		//return destinationProduct.getFeatureCode() == FeatureCode.PANDORA_PREMIUM;
		return true;
	}

	@Override
	public ProductUpgradeSelector visitConsumerGift() {
		return new ConsumerGiftSelector();
	}

	@Override
	public ProductUpgradeSelector visitPaymentBackedCode() {
		return new PaymentBackedCodeSelector();
	}

	@Override
	public ProductUpgradeSelector visitThirdPartyGift() {
		return new ConsumerGiftSelector();
	}

	@Override
	public ProductUpgradeSelector visitAlaCarte() {
		return new BaseUpgradeSelector();
	}

	@Override
	public ProductUpgradeSelector visitComplimentaryTime() {
		return  new ComplimentarySubscriptionSelector();
	}

	@Override
	public ProductUpgradeSelector visitTrialSubscription() {
		if(destinationProductIsPremium()){
			return new PremiumTrialUpgradeSelector();
		}
		return new PlustrialUpgradeSelector();
	}
}
