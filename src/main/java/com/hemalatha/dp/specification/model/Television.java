package com.hemalatha.dp.specification.model;

public class Television extends Product {
	float screenSize;


	public float getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(float screenSize) {
		this.screenSize = screenSize;
	}

	@Override
	public String toString() {
		return "Television{" +
				super.toString()+
				"screenSize=" + screenSize +
				'}';
	}
}
