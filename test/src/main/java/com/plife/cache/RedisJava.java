package com.plife.cache;

import redis.clients.jedis.Jedis;

/**
 * Created by chenjianan on 2016/11/15-15:21.
 * <p>
 * Describe:
 */
public class RedisJava {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("192.168.247.129");
        jedis.auth("jredis");
        System.out.println("Connection to server sucessfully");
        //查看服务是否运行
        System.out.println("Server is running: "+jedis.ping());

        jedis.set("jredistest","sss");
    }
}
