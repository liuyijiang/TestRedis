package com.test.redis.server;

import java.util.List;

import redis.clients.jedis.Jedis;

public class TestGetListFromRedis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Jedis j = new Jedis("192.168.1.142", 6379);
		j.connect();
		//j.l
		//List<Integer> l = (List)j.get("age");

	}

}
