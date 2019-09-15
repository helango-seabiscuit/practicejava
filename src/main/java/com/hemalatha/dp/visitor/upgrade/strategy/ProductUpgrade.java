package com.hemalatha.dp.visitor.upgrade.strategy;

import com.hemalatha.dp.visitor.upgrade.model.ListenerProduct;
import com.hemalatha.dp.visitor.upgrade.model.Product;
import com.hemalatha.dp.visitor.upgrade.model.SubscriptionStatus;

public abstract class ProductUpgrade {


	public  boolean isEligible(SubscriptionStatus status, Product product){ return true;}

	public boolean shouldApplyFirst(){return  false;}

	public String createProductSku(SubscriptionStatus status, ListenerProduct listenerProduct){
		return null;
	}


}
