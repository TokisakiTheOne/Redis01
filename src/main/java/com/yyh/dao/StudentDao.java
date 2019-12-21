package com.yyh.dao;

import com.yyh.po.Student;

import java.util.List;

/**
 * @author YanYuHang
 * @create 2019-12-21-14:39
 */
public interface StudentDao {


    List<Student> selectAll();
}
