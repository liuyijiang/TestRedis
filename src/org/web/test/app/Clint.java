package org.web.test.app;

import java.util.List;

import org.web.test.vo.User;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 * 模拟客户端实现 发布消息
 * @author jim.liu
 *
 */
public class Clint implements Runnable{
   
	public Jedis jedis = null;
	public User user =null;
	public List<Integer> user_friends;
	
	public Clint(Jedis jedis,User user,List<Integer> user_friends){
		this.jedis = jedis;
		this.user = user;
		this.user_friends = user_friends;
	}
	
	@Override
	public void run() {
		while(true){
			int i=1;
			try{
				int key = (int)Math.random() * 5;
				if(key < 2){
					jedis.publish("usermsg_1", "This is user_1's"+i+"message");
					i++;
				}else{
//					JedisPubSub j =  new JedisPubSub(){
//						
//					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}
