package com.hemalatha.paypal;


import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PaypalTest {

	public static void main(String[] args) {
		ZonedDateTime dateTime = ZonedDateTime.now();
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
		System.out.println(sdf.format(new Date()));
		//System.out.println(dateTime.getYear()+""+dateTime.getMonthValue()+""+dateTime.getDayOfMonth()+""+dateTime.getMinute()+""+dateTime.getSecond());
		Immute immute = new Immute();
		List<String> p = immute.getList();
		p.add("test4");
		for(String s:immute.getList()){
			System.out.println(s);
		}


	}

	static class Immute{
		private List<String> list;

		public Immute(){
			this.list = new ArrayList<>();
			this.list.add("Test1");
			this.list.add("Test2");
			this.list.add("Test3");
		}

		public List<String> getList() {
			return new ArrayList<>(list);
		}
	}
}
