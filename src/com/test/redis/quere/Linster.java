package com.test.redis.quere;

import redis.clients.jedis.JedisPubSub;

public class Linster extends JedisPubSub {

	@Override
	public void onMessage(String arg0, String arg1) {
		System.out.println("-----------onMessage----------------");
		System.out.println(arg0);
		System.out.println(arg1);
		System.out.println("----------------------------");
		System.out.println();
	}

	@Override
	public void onPMessage(String arg0, String arg1, String arg2) {
		System.out.println("-------------onPMessage---------------");
		System.out.println(arg0);
		System.out.println(arg1);
		System.out.println(arg2);
		System.out.println("----------------------------");
		System.out.println();
		
	}

	@Override
	public void onPSubscribe(String arg0, int arg1) {
		System.out.println("---------------onPSubscribe-------------");
		System.out.println(arg0);
		System.out.println(arg1);
		System.out.println("----------------------------");
		System.out.println();
		
	}

	@Override
	public void onPUnsubscribe(String arg0, int arg1) {
		System.out.println("-------------onPUnsubscribe---------------");
		System.out.println(arg0);
		System.out.println(arg1);
		System.out.println("----------------------------");
		System.out.println();
		
	}

	@Override
	public void onSubscribe(String arg0, int arg1) {
		System.out.println("------------onSubscribe----------------");
		System.out.println(arg0);
		System.out.println(arg1);
		System.out.println("----------------------------");
		System.out.println();
		
	}

	@Override
	public void onUnsubscribe(String arg0, int arg1) {
		System.out.println("---------onUnsubscribe------------------");
		System.out.println(arg0);
		System.out.println(arg1);
		System.out.println("----------------------------");
		System.out.println();
		
	}

}
