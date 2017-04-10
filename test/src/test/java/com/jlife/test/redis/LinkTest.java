package com.jlife.test.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Created by chen on 2017/3/6.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe: redis 连接测试
 */
public class LinkTest {
    //@Test
    public void link(){
        //连接服务器的  Redis 服务
        Jedis jedis = new Jedis("192.168.247.134",6380);

        jedis.auth("redis");
        System.out.println("Connection to server sucessfully");
        //查看服务是否运行

        jedis.set("java","java");




        System.out.println("Server is running: "+jedis.ping());
        System.out.println(jedis.get("jredistest"));
    }
}
