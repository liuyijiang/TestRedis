package com.test.redis.sortset;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;

import com.alibaba.fastjson.JSON;
import com.test.bean.Ranking;
/**
 * 有序set
 * @author jim.liu
 *
 */
public class TestRedisSortSet {

	private Jedis jedis = null;
		
    public TestRedisSortSet(){
		jedis = new Jedis("192.168.2.135",6379);

	}
    
    //ZADD 向有序集合添加数据
    public void addSortData(){
        //普通添加    	
//		for(int i=0;i<100000; i++){
//			int sum = (int)(Math.random()*500); 
//			Ranking ranking = new Ranking();
//			ranking.setName("第"+i+"号用户");
//			ranking.setSum(sum);
//			jedis.zadd("sortNumbers", sum, JSON.toJSONString(ranking).toString());
//		}
    	
    	Ranking ranking = new Ranking();
		ranking.setName("第10263号用户");
		ranking.setSum(1000000);
		jedis.zadd("sortNumbers", 1000000, JSON.toJSONString(ranking).toString());
    	
		System.out.println("ok");
    }
    
    //zcard 获得有序集合总数
    public void testZcard(){
    	long sum = jedis.zcard("sortNumbers"); //key
    	System.out.println(sum);
    	
    }
    
    //Zcount 获得范围类的数量  ；获得排名在 20 和 50 之间的记录数量
    public void testZcount(){
    	long s = jedis.zcount("sortNumbers", 20, 20);
    	System.out.println(s);
    }
    
    public void getSortData(){
    	Set<String> set = jedis.zrange("sortNumbers", 0, 20);//从小到大
    	//Set<String> set = jedis.zrevrange("sortNumber", 0, -1);//从大到小
    	//Set<String> set = jedis.z
    	int sum = 0;
    	for(String str :set){
    		System.out.println(str);
    		Ranking rank = JSON.parseObject(str, Ranking.class);
    		if(rank.getSum() >= 20 && rank.getSum() <= 50){
    			sum++;
    		}		
    	}
    	System.out.println(sum);
    }
    
    //ZINCRBY 
    public void testZINCRBY(){
    	
    	
    }
    
    //移除
    //移除有序集 key 中，指定排名(rank)区间内的所有成员。
    public void testZREM(){
    	//jedis.zrem(key, members);//移除
    	//jedis.zremrangeByRank(key, start, end);//移除有序集 key 中，指定排名(rank)区间内的所有成员。
    }
    
    //zrank 从小到大排序位置 从 0开始 获得数据的排序位置
    public void testRank(){
    	Ranking ranking = new Ranking();
    	ranking.setName("第10263号用户");
		ranking.setSum(1000000);
    	String str = JSON.toJSONString(ranking).toString();
    	System.out.println(str);
    	long sum = jedis.zrank("sortNumbers", str);
    	System.out.println("从小到大"+sum);
    	sum = jedis.zrevrank("sortNumbers", str);
    	System.out.println("从大到小"+sum);
    }
    
    public void testZSCORE(){
    	Ranking ranking = new Ranking();
    	ranking.setName("第10263号用户");
		ranking.setSum(1000000);
    	String str = JSON.toJSONString(ranking).toString();
    	System.out.println(str);
    	Double scoere = jedis.zscore("sortNumbers", str);
    	System.out.println(scoere);
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestRedisSortSet ts = new TestRedisSortSet();
	    //ts.addSortData();
		//ts.getSortData();
		//ts.testZcard();
		//ts.testZcount();
		ts.testRank();
		ts.testZSCORE();
	}

}
