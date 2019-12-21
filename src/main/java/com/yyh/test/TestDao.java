package com.yyh.test;

import com.yyh.dao.StudentDao;
import com.yyh.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author YanYuHang
 * @create 2019-12-21-14:42
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-redis.xml"})
public class TestDao {

    @Autowired
    private StudentService ss;


    @Test
    public void test() {
        ss.findAll().forEach(System.out::println);
        ss.findAll().forEach(System.out::println);
        ss.findAll().forEach(System.out::println);
        ss.findAll().forEach(System.out::println);
        ss.findAll().forEach(System.out::println);
        ss.findAll().forEach(System.out::println);
        ss.findAll().forEach(System.out::println);
        ss.findAll().forEach(System.out::println);
        ss.findAll().forEach(System.out::println);
        ss.findAll().forEach(System.out::println);
        ss.findAll().forEach(System.out::println);
        ss.findAll().forEach(System.out::println);
        ss.findAll().forEach(System.out::println);
        ss.findAll().forEach(System.out::println);
        ss.findAll().forEach(System.out::println);
        ss.findAll().forEach(System.out::println);
    }


}
