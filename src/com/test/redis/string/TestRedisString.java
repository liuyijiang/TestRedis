package com.test.redis.string;

import java.util.Iterator;
import java.util.List;

import redis.clients.jedis.Jedis;

public class TestRedisString {

	
	private Jedis jedis = null;
	
	public TestRedisString(){
		jedis = new Jedis("192.168.1.143",6379);
	}
	
	
	public void testStringSet(){
		//jedis.set(key, value)
		//jedis.setnx(key, value) 将 key 的值设为 value ，当且仅当 key 不存在。
		jedis.setex("te", 30, "yj"); //设置过期时间
	}
	
	
	public void testStringSetrage(){
		jedis.setrange("test_update", 3, "lover");//替换
		//jedis.mset(keysvalues)
	}
	
	public void testStringAppend(){
		jedis.append("test_update", "_fucking");//添加数据
	}
	
	public void testStringGet(){
		//jedis.get("test");
		List<String> list = jedis.mget("test","test_update");//获得多个key的多个string值
		Iterator it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		System.out.println(jedis.getrange("test_update", 0, 3));//获得范围类的string like substring
		System.out.println(jedis.strlen("test_update"));//获得字符串长度
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestRedisString t = new TestRedisString();
		t.testStringGet();
	}

}
