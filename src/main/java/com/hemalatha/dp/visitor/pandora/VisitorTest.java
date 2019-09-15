package com.hemalatha.dp.visitor.pandora;


import com.hemalatha.dp.visitor.pandora.Store;
import com.hemalatha.dp.visitor.pandora.StoreInfo;

import static org.junit.Assert.*;
public class VisitorTest {

	public static void main(String[] args) {
		StoreInfo googlesStoreInfo = Store.GOOGLEPLAY.visit(StoreInfo.STORE_VISITOR);
		StoreInfo AmazonStoreInfo = Store.AMAZON.visit(StoreInfo.STORE_VISITOR);
		StoreInfo PayPalStoreInfo = Store.PAYPAL.visit(StoreInfo.STORE_VISITOR);
		StoreInfo paymenttechStoreInfo = Store.PAYMENTECH.visit(StoreInfo.STORE_VISITOR);
		StoreInfo incommStoreInfo = Store.INCOMM.visit(StoreInfo.STORE_VISITOR);
		StoreInfo linkpointStoreInfo = Store.LINKPOINT.visit(StoreInfo.STORE_VISITOR);
		StoreInfo  appleStoreInfo = Store.APPLE.visit(StoreInfo.STORE_VISITOR);
		assertEquals("Google Play",googlesStoreInfo.getDisplayableName());
		assertEquals("Amazon",AmazonStoreInfo.getDisplayableName());
		assertEquals("PayPal",PayPalStoreInfo.getDisplayableName());
		assertEquals("Credit Card",paymenttechStoreInfo.getDisplayableName());
		assertEquals("Gift Card",incommStoreInfo.getDisplayableName());
		assertEquals("Credit Card",linkpointStoreInfo.getDisplayableName());
		assertEquals("iTunes Store",appleStoreInfo.getDisplayableName());


	}
}
