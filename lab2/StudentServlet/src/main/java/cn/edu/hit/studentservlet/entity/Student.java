package cn.edu.hit.studentservlet.entity;

import java.time.LocalDate;
import java.util.Date;

public class Student {
    private String sid;
    private String sname;
    private String gender;

    private Integer age;
    private Date birthday;
    private String mid;

    public Student(){

    }
    public Student(String sid, String sname, String gender, Integer age,Date birthday, String mid){
        this.sid = sid;
        this.sname = sname;
        this.gender = gender;
        this.age = new Integer(age);
        this.birthday = new Date(String.valueOf(birthday));
        this.mid = mid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }
}
