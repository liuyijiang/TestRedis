package com.test.redis.quere;

import redis.clients.jedis.Jedis;

public class QuereService extends Thread{

	private Jedis jedis = null;
	private Linster sub = new Linster();
	
    public QuereService(){
		jedis = new Jedis("192.168.2.64",6379);
		
	}
	
	public void run(){
		while(true){
			try{
				jedis.subscribe(sub, "quere");
				Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
}
