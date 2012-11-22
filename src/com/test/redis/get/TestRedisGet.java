package com.test.redis.get;

import java.util.List;

import redis.clients.jedis.Jedis;

public class TestRedisGet {

	private Jedis jedis = null;
	
	public TestRedisGet(){
		jedis = new Jedis("192.168.1.143");
		//System.out.println("--- "+jedis.exists("test")+" ----");
		//System.out.println("--- "+jedis.ping()+" ----");
	}
	
	public void testGetList(){
		List<String> list = jedis.lrange("list", 0, -1);
		for(String str : list){
			System.out.println(str);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestRedisGet t = new TestRedisGet();
		t.testGetList();
	}

}
