package com.yyh.service;

import com.yyh.dao.RedisDao;
import com.yyh.po.Student;
import com.yyh.utils.JacksonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author YanYuHang
 * @create 2019-12-20-11:00
 */
@Service
public class RedisService {

    @Autowired
    private RedisDao rd;


    public void insertStudent(Student student) {
        //1.查询是否有键key值
        String s = rd.get("student_" + student.getStuId());
        if (StringUtils.isEmpty(s)) {
            rd.set("student_" + student.getStuId(), JacksonUtil.toJSON(student));
        }
    }

    public Student getStudent(int id) {
        String jsonValue = rd.get("student_" + id);
        System.out.println("jsonValue = " + jsonValue);
        Student student = JacksonUtil.toJava(jsonValue, Student.class);
        return student;
    }

    public List<Student> getAllStudent(){
        List<Student> list = new ArrayList<Student>();
        Set<String> allKeys = rd.getAllKeys();
        for (String key : allKeys) {
            String s = rd.get(key);
            Student student = JacksonUtil.toJava(s, Student.class);
            list.add(student);
        }
        return list;
    }

    public void updateStudent(Student student){
        rd.set("student_"+student.getStuId(),JacksonUtil.toJSON(student));
    }


}
