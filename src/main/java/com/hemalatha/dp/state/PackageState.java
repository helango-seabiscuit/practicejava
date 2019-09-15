package com.hemalatha.dp.state;

public interface PackageState {

	void next(Package pkg);
	void prev(Package pkg);
	void printStatus();
}


