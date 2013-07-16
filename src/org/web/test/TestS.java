package org.web.test;

import java.net.URLEncoder;

public class TestS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "%E8%AF%84%E8%AE%BA%EF%BC%9A";
		
		String encoderStr = null;
		try{
			encoderStr = new String(str.getBytes("gb2312"),"utf-8");
		}catch(Exception e){
			e.printStackTrace();
		}
       System.out.println(encoderStr);
	}

}
