package com.jlife.bootest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by chen on 2017/4/7.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe:
 */
@Configuration
public class JedisConf {

    @Bean
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(10);
        jedisPoolConfig.setMaxTotal(50);
        jedisPoolConfig.setTestOnBorrow(true);
        return jedisPoolConfig;
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){
        JedisConnectionFactory jedisConnectionFactory=new JedisConnectionFactory();
        jedisConnectionFactory.setUsePool(true);
        jedisConnectionFactory.setHostName("192.168.247.134");
        jedisConnectionFactory.setPort(6380);
        jedisConnectionFactory.setTimeout(100000);
        jedisConnectionFactory.setPassword("redis");
        jedisConnectionFactory.setPoolConfig(jedisPoolConfig());
        return jedisConnectionFactory;
    }



    @Bean
    public RedisTemplate redisTemplate(){
        RedisTemplate redisTemplate =new RedisTemplate();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        redisTemplate.setDefaultSerializer(new StringRedisSerializer());//序列化
        return redisTemplate;
    }

    @Bean
    public JedisUtil jedisUtil(){
        JedisUtil jedisUtil =new JedisUtil();
        jedisUtil.setRedisTemplate(redisTemplate());
        return jedisUtil;
    }



}
