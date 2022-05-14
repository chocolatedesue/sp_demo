package com.example.demo;

import com.example.demo.entity.teacher;
import com.example.demo.mapper.teacherMapper;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

@SpringBootTest
class DemoApplicationTests {
    @Mapper
    @Autowired
    teacherMapper mapper;

    @Resource
    @Autowired
    StringRedisTemplate template;

    @Autowired
    JavaMailSender sender;

    //    @Autowired
//    JedisPool jedisPool;
    @Test
    void contextLoads() {
        mapper.addTeacher(new teacher("张三"));
    }

    @Test
    void sendMail() {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setText("hello_world");
        msg.setSubject("askldjll");
        msg.setTo("ccdesue@163.com");
        msg.setFrom("ccdesue@163.com");
        sender.send(msg);

    }

    @Test
    void try_redis() {
//        RedisProperties.Jedis jedis = new RedisProperties.Jedis();
//        jedis.
        try (Jedis jedis = new Jedis("192.168.50.16", 6379)) {
            jedis.set("a", String.valueOf(233));
//            System.out.println(jedis.get("a"));
            var res = jedis.get("a");
//            String s = "233";
            assert res.equals("233");

        }

    }

    @Test
    void spring_redis() {
        template.opsForValue().set("b", "123");
        var res = template.opsForValue().get("b");
        System.out.println(res);
        assert res.equals("123");

    }
}
