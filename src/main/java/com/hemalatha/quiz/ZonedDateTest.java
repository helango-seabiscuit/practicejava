package com.hemalatha.quiz;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TimeZone;

public class ZonedDateTest {

	public static void main(String[] args) {
		String timestampMillis =
				"1527705572000";
		//System.out.println(ZonedDateTime.now());
		Instant instant = Instant.ofEpochMilli(Long.parseLong(timestampMillis));
		ZonedDateTime time =  ZonedDateTime.ofInstant(instant, ZoneId.of("America/Los_Angeles"));
		System.out.println(time);
		System.out.println(ZonedDateTime.now());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss zzzz").withZone(ZoneId.of("America/Los_Angeles"));
		System.out.println(formatter.format(time));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		System.out.println(time.isBefore(ZonedDateTime.now()));
		System.out.println(ZonedDateTime.now().toInstant().getEpochSecond());
//		System.out.println(ZoneId.getAvailableZoneIds());
//		System.out.println(ZoneId.systemDefault());

		ZonedDateTime now = ZonedDateTime.now();
		ZonedDateTime prev = now.minusDays(4);
		System.out.println(prev.compareTo(now));
		System.out.println(new ArrayList<>(null));


		}
	}

