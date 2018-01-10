package com.n26.txnanalysis.util;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		long l1 = System.currentTimeMillis();
		Thread.sleep(323);
		long l2 = System.currentTimeMillis();
		System.out.println(l1 - l2);
	}

}