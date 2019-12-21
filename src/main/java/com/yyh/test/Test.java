package com.yyh.test;

import com.yyh.po.Student;
import com.yyh.service.RedisService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.swing.*;
import java.util.List;
import java.util.Set;

/**
 * @author YanYuHang
 * @create 2019-12-20-9:05
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-redis.xml"})
public class Test {

    @Autowired
    private JedisPool jp;
    @Autowired
    private RedisService rs;


    @org.junit.Test
    public void test() {
        //1.创建redis的java客户端
        // Jedis jedis=new Jedis(IP地址/主机地址,端口号);
        Jedis jedis = new Jedis("192.168.102.166", 6379);
        //2.使用redis
        //  get(key)  根据key键值 和获取 对应的 value值
        //  set(key,value)
        //  del(key)  根据key  删除key和value
        //  keys      可以根据条件获取多个key
        //  exists    判断是否存在这个key值   1  存在   0  不存在
        //  flushall  删除所有的key

       // jedis.set("t1","demo");
    }

    @org.junit.Test
    public void testJedisPool() {
        //getResource  获取一个操作链接  
        jp.getResource().set("test01", "这个整个spring做的测试操作");
        String test01 = jp.getResource().get("test01");
        System.out.println("test01 = " + test01);
    }

    @org.junit.Test
    public void testServiceSet() {
        Student stu=new Student(3,"a");
        rs.insertStudent(stu);
    }
    @org.junit.Test
    public void testServiceGet() {
        Student student = rs.getStudent(1);
        System.out.println("student = " + student);
    }
    @org.junit.Test
    public void testServiceGetAllStudent() {
        List<Student> allStudent = rs.getAllStudent();
        allStudent.forEach(System.out::println);
    }
    @org.junit.Test
    public void testServiceUpdateStudent() {
    }
}
