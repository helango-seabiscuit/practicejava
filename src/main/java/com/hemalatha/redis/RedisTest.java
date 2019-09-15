package com.hemalatha.redis;

import redis.clients.jedis.Jedis;

import java.util.Map;
import java.util.Set;

public class RedisTest {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("127.0.0.2",9898);
		jedis.set("events/city/rome","32,15,223,828");
		String cachedResponse = jedis.get("events/city/rome");
		System.out.println(cachedResponse);

		//Lists
		jedis.lpush("queue#tasks","firstTask");
		jedis.lpush("queue#tasks","secondTask");

		String task = jedis.rpop("queue#tasks");
		 task = jedis.rpop("queue#tasks");
		System.out.println(task);

		//Sets
		jedis.sadd("nicknames","nickname#1");
		jedis.sadd("nicknames","nickname#2");
		jedis.sadd("nicknames","nickname#1");

		Set<String> nicknames = jedis.smembers("nicknames");
		System.out.println(nicknames);
		System.out.println(jedis.sismember("nicknames","nickname#1"));

		//Hashset
		jedis.hset("user#1","name","Peter");
		jedis.hset("user#1","job","politician");

		String name = jedis.hget("user#1","name");
		System.out.println(name);
		Map<String,String> fields = jedis.hgetAll("user#1");
		System.out.println(fields);
	}
}
