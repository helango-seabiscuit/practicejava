package com.hemalatha.dp.visitor.pandora;

public class StoreInfo {

	public static final Visitor STORE_VISITOR = new Visitor();

	private boolean isDirectBilled;
	private boolean isVendorBilled;
	private String displayableName;

	public StoreInfo(boolean isDirectBilled, boolean isVendorBilled, String displayableName) {
		this.isDirectBilled = isDirectBilled;
		this.isVendorBilled = isVendorBilled;
		this.displayableName = displayableName;
	}


	public boolean isDirectBilled() {
		return isDirectBilled;
	}

	public void setDirectBilled(boolean directBilled) {
		isDirectBilled = directBilled;
	}

	public boolean isVendorBilled() {
		return isVendorBilled;
	}

	public void setVendorBilled(boolean vendorBilled) {
		isVendorBilled = vendorBilled;
	}

	public String getDisplayableName() {
		return displayableName;
	}

	public void setDisplayableName(String displayableName) {
		this.displayableName = displayableName;
	}

	static class  Visitor implements StoreVisitor<StoreInfo> {

		@Override
		public StoreInfo visitPaymentTech() {
			return new StoreInfo(true,false,"Credit Card");
		}

		@Override
		public StoreInfo visitPaypal() {
			return new StoreInfo(true,false,"PayPal");
		}

		@Override
		public StoreInfo visitApple() {
			return  new StoreInfo(false,true,"iTunes Store");
		}

		@Override
		public StoreInfo visitGoogle() {
			return new StoreInfo(false, true,"Google Play");
		}

		@Override
		public StoreInfo visitAmazon() {
			return new StoreInfo(false, true,"Amazon");
		}

		@Override
		public StoreInfo visitIncomm() {
			return new StoreInfo(false,false,"Gift Card");
		}

		@Override
		public StoreInfo visitNone() {
			return new StoreInfo(false,false,"None");
		}

		@Override
		public StoreInfo visitLinkpoint() {
			return new StoreInfo(true,false,"Credit Card");
		}
	}
}
