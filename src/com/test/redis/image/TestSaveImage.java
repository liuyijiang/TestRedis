package com.test.redis.image;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import redis.clients.jedis.Jedis;
/**
 * test save a image
 * @author jim.liu
 *
 */
public class TestSaveImage {

	public static final String PATH =System.getProperty("user.dir") + File.separator + "image";
	
	private Jedis jedis = null;
	
	public TestSaveImage(){
		jedis = new Jedis("192.168.1.138",6379);
		System.out.println("liuyijiang:"+jedis.hexists("hash_test", "liuyijiang"));//测试key 是否存在
		System.out.println("yuzhu:"+jedis.hexists("hash_test", "yuhzu"));
		//jedis.hkeys(key) 返回所有的key值
		//jedis.hvals(key) 返回所有的value
	}
	
	public void testSave() throws Exception{
		File file = new File(PATH+File.separator+"ppp.jpg");
		FileInputStream fis = new FileInputStream(file);
		byte[] buffer = new byte[10240];
		int len;//读取到的实际字节数
		while((len = fis.read(buffer)) != -1 ){//-1到尾
			System.out.println(len);
			jedis.set("image".getBytes(), buffer);
		}
		System.out.print("ok");
	}
	
	public void getImage() throws Exception{
		File file2 = new File(PATH+File.separator+"ppp1.jpg");
		FileOutputStream dos = new FileOutputStream(file2);
		byte[] buffer = jedis.get("image".getBytes());
		dos.write(buffer);
		dos.flush();
		dos.close();
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestSaveImage t = new TestSaveImage();
		try{
		t.getImage();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
