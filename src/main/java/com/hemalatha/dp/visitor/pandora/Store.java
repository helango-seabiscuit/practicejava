package com.hemalatha.dp.visitor.pandora;

public enum Store {

	NONE("NONE"){
		@Override
		public <T> T visit(StoreVisitor<T> visitor) {
			return visitor.visitNone();
		}
	},
	PAYMENTECH("PAYMENTECH"){
		@Override
		public <T> T visit(StoreVisitor<T> visitor) {
			return visitor.visitPaymentTech();
		}
	},
	PAYPAL("PAYPAL"){
		@Override
		public <T> T visit(StoreVisitor<T> visitor) {
			return visitor.visitPaypal();
		}
	},
	GOOGLEPLAY("GPLY"){
		@Override
		public <T> T visit(StoreVisitor<T> visitor) {
			return visitor.visitGoogle();
		}
	},
	APPLE("APL"){
		@Override
		public <T> T visit(StoreVisitor<T> visitor) {
			return visitor.visitApple();
		}
	},
	AMAZON("AMZN"){
		@Override
		public <T> T visit(StoreVisitor<T> visitor) {
			return visitor.visitAmazon();
		}
	},
	INCOMM("INC"){
		@Override
		public <T> T visit(StoreVisitor<T> visitor) {
			return visitor.visitIncomm();
		}
	},
	LINKPOINT("LNK"){
		@Override
		public <T> T visit(StoreVisitor<T> visitor) {
			return visitor.visitLinkpoint();
		}
	};


	private final String name;
	Store(String name){
		this.name = name;
	}

	public abstract <T> T visit(StoreVisitor<T> visitor);
}
