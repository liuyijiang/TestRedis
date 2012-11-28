package org.web.test.app;

import org.web.test.vo.User;

import redis.clients.jedis.Jedis;

public class TestStart {
   
    private Jedis jedis = null;
	
	
	public TestStart(){
		jedis = new Jedis("192.168.1.138");
//		User u1 = new User(1,"liuyijiang");
//		User u2 = new User(2,"xuting");
//		User u3 = new User(3,"chengxiaoting");
//		User u4 = new User(4,"user3");
	}
	
	public void testPublish(int i){
		jedis.publish("mess", "This is user_1's"+i+"message");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestStart t = new TestStart();
		t.testPublish(9);
	}

}
