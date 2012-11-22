package com.test.redis.server;

import redis.clients.jedis.Jedis;

import com.test.redis.tools.Byte2Object;
import com.test.redis.vo.Student;

public class TestRedisByJava {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		Jedis j = new Jedis("192.168.1.142", 6379);
		j.connect();
//		j.set("name1", "ppps");
//		Student s = new Student();
//		s.setName("xuting");
//		byte[] bs = Byte2Object.object2Byte(s);
//		j.set("stu".getBytes(), bs);
		
		Student s = (Student)Byte2Object.byte2Object(j.get("stu".getBytes()));
		System.out.println(s.getName());
		//j.set("stu", s);

//		JedisPool pool = new JedisPool
//		Jedis jedis = pool.getResource();
//
//		jedis.set("foo", "bar");
//		String foobar = jedis.get("foo");
//		assert foobar.equals("bar");
//
//		pool.returnResource(jedis);
//		pool.destroy();

	}

}
