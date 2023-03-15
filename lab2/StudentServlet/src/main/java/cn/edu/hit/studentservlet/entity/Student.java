package cn.edu.hit.studentservlet.entity;

import java.time.LocalDate;
import java.util.Date;

public class Student {
    private char[] sid;
    private char[] sname;
    private char gender;

    private Integer age;
    private Date birthday;
    private char[] mid;

    public Student(){

    }
    public Student(char[] sid, char[] sname, char gender, Integer age,Date birthday, char[] mid){
        this.sid = sid;
        this.sname = sname;
        this.gender = gender;
        this.age = new Integer(age);
        this.birthday = new Date(String.valueOf(birthday));
        this.mid = mid;
    }

    public char[] getSid() {
        return sid;
    }

    public void setSid(char[] sid) {
        this.sid = sid;
    }

    public char[] getSname() {
        return sname;
    }

    public void setSname(char[] sname) {
        this.sname = sname;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
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

    public char[] getMid() {
        return mid;
    }

    public void setMid(char[] mid) {
        this.mid = mid;
    }
}
