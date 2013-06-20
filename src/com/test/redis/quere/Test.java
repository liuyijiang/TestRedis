package com.test.redis.quere;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		QuereService s = new QuereService();
		s.start();
		QuereClient q = new QuereClient();
		q.start();

	}

}
