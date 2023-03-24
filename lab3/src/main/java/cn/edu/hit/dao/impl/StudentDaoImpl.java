package cn.edu.hit.dao.impl;

import cn.edu.hit.dao.MajorDao;
import cn.edu.hit.dao.StudentDao;
import cn.edu.hit.entity.Student;
import cn.edu.hit.db.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public void add(Student stu) {
        DBUtil db = new DBUtil();
        String sid = stu.getSid();
        String sname = stu.getSname();
        String gender = stu.getGender();
        Integer age = stu.getAge();
        String mid = stu.getMid();
        String birthday = stu.getBirthday();

        db.executeUpdate("INSERT INTO student(sid,sname,age,gender,mid,birthday) values" +
                "('" + sid + "','" + sname + "'," + age + ",'" + gender + "','" + mid + "','" + birthday + "')");
        db.close();
    }

    @Override
    public void modify(Student stu) {
        DBUtil db = new DBUtil();
        String sid = stu.getSid();
        String sname = stu.getSname();
        String gender = stu.getGender();
        Integer age = stu.getAge();
        String mid = stu.getMid();
        String birthday = stu.getBirthday();

        db.executeUpdate("UPDATE student set sname='" + sname + "', gender='" + gender +
                "', age=" + age + ", mid='" + mid + "', birthday='" + birthday + "' where sid='" + sid + "'");
    }

    @Override
    public void remove(String sid) {
        DBUtil dbUtil = new DBUtil();
        dbUtil.executeUpdate("delete from student where sid = '" + sid + "'");
        dbUtil.close();
    }

    @Override
    public List<Student> getAll(String sql) {
        List<Student> stus = new ArrayList<>();
        DBUtil db = new DBUtil();

        ResultSet rs = db.executeQuery(sql);

        String sid = null;
        String sname = null;
        String gender = null;
        Integer age = null;
        String mid = null;
        String birthday = null;
        String mname = null;
        try {
            while(rs.next()){
                MajorDao majorDao = new MajorDaoImpl();
                sid = rs.getString("sid");
                sname = rs.getString("sname");
                gender = rs.getString("gender");
                age = rs.getInt("age");
                mid = rs.getString("mid");
                mname = rs.getString("mname");
                birthday = rs.getString("birthday");
                stus.add( new Student(sid,sname,gender,age,birthday,mid,mname));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        db.close();
        return stus;
    }

    @Override
    public Student getBySid(String sid) {
        DBUtil db = new DBUtil();

        ResultSet rs = db.executeQuery("select * from student where sid = '" + sid + "'");

        String sname = null;
        String gender = null;
        Integer age = null;
        String mid = null;
        String birthday = null;
        try {
            while(rs.next()){
                sname = rs.getString("sname");
                gender = rs.getString("gender");
                age = rs.getInt("age");
                mid = rs.getString("mid");
                birthday = rs.getString("birthday");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            db.close();

            return sname==null ? null : new Student(sid,sname,gender,age,birthday,mid);
        }
    }
}
