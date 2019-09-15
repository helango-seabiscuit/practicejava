package com.hemalatha.dp.state;


import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.Test;

import java.time.Clock;
import java.time.ZonedDateTime;
import java.util.Date;

public class TestStateDesignPattern {

	@Test
	public void givenNewPackage_whenPackageReceived_thenStateReceived(){
		Package pkg = new Package();

		assertThat(pkg.getState(), instanceOf(OrderedState.class));
		pkg.nextState();
		assertThat(pkg.getState(), instanceOf(DeliveredState.class));
		pkg.nextState();
		assertThat(pkg.getState(), instanceOf(ReceivedState.class));

	}

	@Test
	public void testGoogleApiDate(){
		Long expiryDateInMillis = 1537500702877l;
		Long startDateInMillis = 1521595923590l;
		System.out.println(new Date(expiryDateInMillis));
		System.out.println(new Date(startDateInMillis));
	}
}
