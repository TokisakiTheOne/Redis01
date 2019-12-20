package com.yyh.po;

/**
 * @author YanYuHang
 * @create 2019-12-20-9:58
 */
public class Student {
    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                '}';
    }

    private int stuId;
    private String stuName;

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }
}
