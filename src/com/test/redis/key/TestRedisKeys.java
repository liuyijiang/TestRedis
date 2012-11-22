package com.test.redis.key;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

/**
 * 这个类来测试redis中key的操作
 * @author jim.liu
 *
 */
public class TestRedisKeys {

	private Jedis jedis = null;
	
	public TestRedisKeys(){
		jedis = new Jedis("192.168.1.143",6379);
		System.out.println("db1:"+jedis.exists("test"));
		jedis.select(1);
		System.out.println("db1:"+jedis.exists("test"));
		jedis.select(0);
		System.out.println("db1:"+jedis.exists("test"));
	}
	
	//没有对应的key返回0 正常返回1 
	public void testDeleteKey(){
		System.out.println(jedis.del("test"));
	}
	
	//查看当前所有key
	public void testShowKeys(){
		Set<String> set = jedis.keys("*");
		Iterator it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	}
	
	//随即key
	public void testShowRadomKey(){
		System.out.println(jedis.randomKey());
	}
	
	public void testTTL(){
		jedis.expire("p", 10);//设置一个key的过期时间
		boolean flag = true;
		while(flag){
			try{
				long i = jedis.ttl("p");
				System.out.println(i);
				Thread.sleep(1000);
				if(i == -1){
					flag = false;
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		System.out.println("ok");
	}
	
	/**
	 * 修改key name
	 */
	public void testRenameKey(){
		System.out.println("test_update: "+jedis.get("test_update"));
		System.out.println("test: " + jedis.get("test"));
		jedis.rename("test", "test_update");
		System.out.println("test_update: "+jedis.get("test_update"));
		//jedis.renamenx(oldkey, newkey); 当且仅当 newkey 不存在时，将 key 改名为 newkey 
	}
	
	/**
	 * 排序列表
	 */
	public void testSort(){
		List<String> set = jedis.sort("nums");
		Iterator it = set.iterator();
		while(it.hasNext()){
			System.out.print(it.next() + " - ");
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestRedisKeys t = new TestRedisKeys();
		//t.testDeleteKey();
		//t.testShowKeys();
		//t.testShowRadomKey();
		//  t.testTTL();
		//t.testRenameKey();
		t.testSort();
	}

}
