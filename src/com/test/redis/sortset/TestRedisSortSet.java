package com.test.redis.sortset;

import redis.clients.jedis.Jedis;
/**
 * 有序set
 * @author jim.liu
 *
 */
public class TestRedisSortSet {

	private Jedis jedis = null;
		
    public TestRedisSortSet(){
		jedis = new Jedis("192.168.1.144",6379);
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
