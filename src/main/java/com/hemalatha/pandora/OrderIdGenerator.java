//package com.hemalatha.pandora;
//
//import org.apache.commons.codec.binary.Base32;
//import org.apache.commons.lang3.StringUtils;
//
//import java.nio.ByteBuffer;
//import java.util.Arrays;
//import java.util.UUID;
//import java.util.concurrent.atomic.AtomicInteger;
//
//public class OrderIdGenerator {
//
//	public static void main(String[] args) {
//		OrderIdGenerator generator = new OrderIdGenerator();
//		System.out.println(generator.generateOrderID("hema"));
//	}
//
//	private final static AtomicInteger sequenceNumber = new AtomicInteger(0);
//
//	private static final int PAYMENTECH_ORDER_ID_LENGTH = 22;
//
//	public String generateOrderID(String skuIdentifier) {
//		ByteBuffer buffer = ByteBuffer.allocate(10);
//		buffer.putLong(System.currentTimeMillis());
//		buffer.putShort(getNextSequenceNumber());
//		String token = new Base32().encodeAsString(buffer.array());
//		String orderId = skuIdentifier + token;
//		return StringUtils.leftPad(orderId, PAYMENTECH_ORDER_ID_LENGTH, '0');
//	}
//
//	private short getNextSequenceNumber() {
//		// Mod the order number in order to restrict it to a maximum of three digits.
//		return (short)(sequenceNumber.incrementAndGet() % 1000);
//	}
//}
