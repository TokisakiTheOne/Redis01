package com.yyh.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yyh.po.Student;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author YanYuHang
 * @create 2019-12-21-13:35
 */
public class TestList {


    @Test
    public void testJavaListToJsonArray() throws JsonProcessingException {
        Student stu1 = new Student(1, "张三");
        Student stu2 = new Student(2, "李四");
        Student stu3 = new Student(3, "王五");
        List<Student> list = new ArrayList<Student>();
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        //1.创建映射对象
        ObjectMapper om = new ObjectMapper();
        //2.执行转换操作   把JAVA  TO   JSON
        String json = om.writeValueAsString(list);
        System.out.println(json);
        /************************************************/
        Jedis jedis = new Jedis("192.168.102.166", 6379);
        jedis.set("student", json);
    }

    @Test
    public void testJsonArrayToJavaList() throws IOException {
        Jedis jedis = new Jedis("192.168.102.166", 6379);
        String jsonArray = jedis.get("student");
        System.out.println("jsonArray = " + jsonArray);
        //1.创建映射对象
        ObjectMapper om = new ObjectMapper();
        //2.1执行转换操作  JSON TO JAVA
        List<Student> list = om.readValue(jsonArray, new TypeReference<List<Student>>() {
        });
        for (Student student : list) {
            System.out.println("student = " + student);
        }
        System.out.println("***************************************************");
        //2.2
        JavaType javaType = om.getTypeFactory().constructParametricType(List.class, Student.class);
        List<Student> list1 = om.readValue(jsonArray, javaType);
        for (Student student : list1) {
            System.out.println("student = " + student);
        }
    }
}
