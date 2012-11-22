package com.test.redis.list;

import redis.clients.jedis.Jedis;

public class TestRedisList {

	
	private Jedis jedis = null;
	
	public TestRedisList(){
		jedis = new Jedis("192.168.1.143",6379);
	}
	
	public void saveList(){
		jedis.lpush("test_list", "103","89","234","12");//key 不存在 存在都不影响
		//jedis.lpushx(key, string);//key 存在
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestRedisList t = new TestRedisList();
		t.saveList();
	}

}
