package com.yyh.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yyh.dao.RedisDao;
import com.yyh.dao.StudentDao;
import com.yyh.po.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @author YanYuHang
 * @create 2019-12-21-14:44
 */
@Service
public class StudentService {

    @Autowired
    private StudentDao sd;
    @Autowired
    private RedisDao rd;

    public List<Student> findAll() {
        //第二次 及以后查询redis数据库
        String json = rd.get("student");
        if (json != null) {
            ObjectMapper om = new ObjectMapper();
            JavaType javaType = om.getTypeFactory().constructParametricType(List.class, Student.class);
            try {
                List<Student> list = om.readValue(json, javaType);
                System.out.println("执行了redis数据库缓存查询");
                return list;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            //第一次查询mysql数据库
            List<Student> list = sd.selectAll();
            System.out.println("执行了mysql数据库查询");
            ObjectMapper om = new ObjectMapper();
            try {
                String s = om.writeValueAsString(list);
                rd.set("student", s);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return list;
        }
        return null;
    }


}
