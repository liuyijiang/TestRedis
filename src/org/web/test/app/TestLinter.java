package org.web.test.app;

import redis.clients.jedis.Jedis;

public class TestLinter {

    private Jedis jedis = null;
	
	public TestLinter(){
		jedis = new Jedis("192.168.1.138");
	}
	
	public void linter(){
		MessageGet m = new MessageGet();
		jedis.subscribe(m, "mess");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestLinter t = new TestLinter();
		t.linter();
	}

}
