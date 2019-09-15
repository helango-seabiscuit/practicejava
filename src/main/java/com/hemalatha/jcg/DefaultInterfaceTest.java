package com.hemalatha.jcg;

public class DefaultInterfaceTest {


	public static void main(String[] args) {
		TestService testService = new TestService(){};
		testService.testPrint();
		testService.testPrint2();
	}
}

interface  TestService{
	default void testPrint(){
		System.out.println("Default print");
	}

	default void testPrint2(){
		System.out.println("Default print 2");
	}
}
