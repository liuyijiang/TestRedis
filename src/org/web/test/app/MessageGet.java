package org.web.test.app;

import redis.clients.jedis.JedisPubSub;

public class MessageGet extends JedisPubSub{

	@Override
	public void onMessage(String arg0, String arg1) {
		// TODO Auto-generated method stub
		System.out.println("##################onMessage start##################");
		System.out.println("#"+arg0+" --- "+arg1+"                            #");
		System.out.println("##################onMessage end####################");
	}

	@Override
	public void onPMessage(String arg0, String arg1, String arg2) {
		// TODO Auto-generated method stub
		System.out.println("##################onPMessage start##################");
		System.out.println("#"+arg0+" --- "+arg1+"----"+arg2+"                 #");
		System.out.println("##################onPMessage end####################");
	}

	@Override
	public void onPSubscribe(String arg0, int arg1) {
		// TODO Auto-generated method stub
		System.out.println("##################onPSubscribe start##################");
		System.out.println("#"+arg0+" --- "+arg1+"                               #");
		System.out.println("##################onPSubscribe end####################");
	}

	@Override
	public void onPUnsubscribe(String arg0, int arg1) {
		// TODO Auto-generated method stub
		System.out.println("##################onPUnsubscribe start##################");
		System.out.println("#"+arg0+" --- "+arg1+"                               #");
		System.out.println("##################onPUnsubscribe end####################");
	}

	@Override
	public void onSubscribe(String arg0, int arg1) {
		// TODO Auto-generated method stub
		System.out.println("##################onSubscribe start##################");
		System.out.println("#"+arg0+" --- "+arg1+"                               #");
		System.out.println("##################onSubscribe end####################");
	}

	@Override
	public void onUnsubscribe(String arg0, int arg1) {
		// TODO Auto-generated method stub
		System.out.println("##################onUnsubscribe start##################");
		System.out.println("#"+arg0+" --- "+arg1+"                               #");
		System.out.println("##################onUnsubscribe end####################");
	}

}
