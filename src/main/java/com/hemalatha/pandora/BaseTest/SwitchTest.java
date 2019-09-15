package com.hemalatha.pandora.BaseTest;

import java.io.File;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SwitchTest {

	public static void main(String[] args) throws ParseException {


		Double d = 0.000001;
		System.out.println(Double.compare(d,0));

		double dbl = (double)499/100;
		double dblTax = 0.38;
		double ref= dbl + dblTax;
		double total = 5.37;
		System.out.println(ref);
		System.out.println(total);
		BigDecimal d1 = BigDecimal.valueOf(dbl);
		BigDecimal d2 = BigDecimal.valueOf(dblTax);
		BigDecimal d3 = d1.add(d2);
		System.out.println(d3);
		System.out.println(d3.compareTo(BigDecimal.valueOf(total)));
		System.out.println(BigDecimal.ZERO.divide(BigDecimal.valueOf(100)));
		System.out.println(BigDecimal.valueOf(0).compareTo(BigDecimal.ZERO) == 0);

		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date purchaseDate = DATE_FORMAT.parse("2019-03-05T05:45:56");
		Instant purchaseTimeInstant = Instant.ofEpochMilli(purchaseDate.getTime());
		//String s = purchaseDate.toOffsetDateTime().toString();
		ZonedDateTime purchaseDatePst = ZonedDateTime.ofInstant(purchaseTimeInstant, ZoneId.systemDefault());
		ZonedDateTime now = ZonedDateTime.now();
		purchaseDatePst = purchaseDatePst.withMonth(now.getMonth().getValue());
		long diffSeconds = 24*60*60;
		System.out.println(purchaseDatePst.toEpochSecond() - now.toEpochSecond() );
		System.out.println(purchaseDatePst.toEpochSecond() - now.toEpochSecond() < diffSeconds );


		List<Integer> al = Arrays.asList(2,4,8);
		int sum = 0;
		for(int i:al){
			sum = (sum *10 )+ i;
		}

		System.out.println(sum);
	}
}
