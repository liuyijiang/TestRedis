package com.test.redis.hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;

/**
 * 测试redis  hash 操作
 * @author jim.liu
 *
 */
public class TestReidsHash {
	
	private Jedis jedis = null;
	
	public TestReidsHash(){
		jedis = new Jedis("192.168.1.143",6379);
		System.out.println("liuyijiang:"+jedis.hexists("hash_test", "liuyijiang"));//测试key 是否存在
		System.out.println("yuzhu:"+jedis.hexists("hash_test", "yuhzu"));
		//jedis.hkeys(key) 返回所有的key值
		//jedis.hvals(key) 返回所有的value
	}
	
	public void testSaveHash(){
//		Set<String> set = new HashSet<String>();
//		set.add("key1");
//		set.add("key2");
//		set.add("key3");
//		jedis.hset("hash_test", "chengxiaoting", "23");//像一个map 
		//jedis.hset(key, field, value)
		//jedis.hsetnx(key, field, value);//SETNX 是『SET if Not eXists』(如果不存在，则 SET)的简写。
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("xuyucheng", "23");
		map.put("yuzhu","24");
		jedis.hmset("hash_test", map);//一次性多插入多条数据
	}
	
	public void testGetAll(){
		Map<String,String> map = jedis.hgetAll("hash_test");//获得所有值 返回map
		Set set = map.keySet();
		Iterator it = set.iterator();
		while(it.hasNext()){
			System.out.println(map.get(it.next()));
		}
	}
	
	public void testHDel(){
		jedis.hdel("hash_test", "xuyucheng","yuzhu");//删除哈希表 key 中的一个或多个指定域，不存在的域将被忽略。
	}
	
	public void testHLen(){//return hash set length
		System.out.println(jedis.hlen("hash_test"));
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestReidsHash t = new TestReidsHash();
//		t.testGetAll();
//		t.testHDel();
//		t.testGetAll();
		//t.testHLen();
	}

}
