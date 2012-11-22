package com.test.redis.save;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import redis.clients.jedis.Jedis;

import com.test.redis.tools.Byte2Object;

public class TestRedisSave {
    
	private Jedis jedis = null;
	
	public TestRedisSave(){
		jedis = new Jedis("192.168.1.143");
		System.out.println("--- "+jedis.exists("test")+" ----");
		System.out.println("--- "+jedis.ping()+" ----");
	}
	
	/**
	 * 保存string类型的数据
	 */
	public void testSaveString(){
		jedis.set("test","刘一江");
		testShowString();
	}
	
	public void testShowString(){
		System.out.println(jedis.get("test"));
	}
	
	//--------------------------------------
	
	public void testSaveSet(){
		Set<String> set = new HashSet<String>();
		set.add("liuyijiang");
		set.add("xuting");
		set.add("chengxiaoting");
		jedis.set("strset".getBytes(), Byte2Object.object2Byte(set));
		testShowSet();
	}
	
	/**
	 * 存set
	 */
	public void testShowSet(){
		Set<String> set = (Set<String>) Byte2Object.byte2Object(jedis.get("strset".getBytes()));
		Iterator it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	
	public static void main(String[] args){
		TestRedisSave t = new TestRedisSave();
		t.testSaveString();
	}
	
}
