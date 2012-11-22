package com.test.redis.tools;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Byte2Object {
  
	public static Object byte2Object(byte[] data){
		Object obj = null;
		try{
			ByteArrayInputStream bi = new ByteArrayInputStream(data);
			ObjectInputStream ins = new ObjectInputStream(bi);
			obj = ins.readObject();
		}catch(Exception e){
			e.printStackTrace();
		}
		return obj;
	}
	
	public static byte[] object2Byte(Object obj){
		byte[] re = null;
		try{
			ByteArrayOutputStream  ba = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(ba);
		    out.writeObject(obj);
		    re =  ba.toByteArray();
		}catch(Exception e){
			e.printStackTrace();
		}
		return re;
	}
	
	
}
