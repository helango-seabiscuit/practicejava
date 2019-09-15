package com.hemalatha.dp.state;

public class ReceivedState implements PackageState {
	@Override
	public void next(Package pkg) {
		System.out.println("Package is already received by client");
	}

	@Override
	public void prev(Package pkg) {
        pkg.setState(new DeliveredState());
	}

	@Override
	public void printStatus() {
		System.out.println("Package is received by client");
	}
}
