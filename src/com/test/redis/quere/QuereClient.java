package com.test.redis.quere;

import redis.clients.jedis.Jedis;

/**
 * 实现一个消息队列
 * @author Administrator
 *
 */
public class QuereClient extends Thread {

	private Jedis jedis = null;
	
	public QuereClient(){
		jedis = new Jedis("192.168.2.153",6379);
	}

	public void run(){
		for(int i=0 ;i<10;i++){
			try{
				jedis.publish("quere", "pushmessage"+i);
				Thread.sleep(2000);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public void pushMessage(){
		
	}
	
	
}
