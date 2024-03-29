package cn.edu.hit.studentservlet.dao.impl;

import cn.edu.hit.studentservlet.dao.MajorDao;
import cn.edu.hit.studentservlet.dao.StudentDao;
import cn.edu.hit.studentservlet.db.DBUtil;
import cn.edu.hit.studentservlet.entity.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public boolean add(Student stu) {
        DBUtil db = new DBUtil();
        String sid = stu.getSid();
        String sname = stu.getSname();
        String gender = stu.getGender();
        Integer age = stu.getAge();
        String mid = stu.getMid();
        String birthday = stu.getBirthday();

        if(getBySid(sid) == null){
            db.executeUpdate("INSERT INTO student(sid,sname,age,gender,mid,birthday) values" +
                    "('" + sid + "','" + sname + "'," + age + ",'" + gender + "','" + mid + "','" + birthday + "')");
            db.close();
            return true;
        }

        db.close();
        return false;
    }

    /**
     * 学号不可更改
     * @param stu
     */
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
                "', age='" + age + "', mid='" + mid + "', birthday='" + birthday + "',where sid='" + sid + "'");
    }

    @Override
    public void remove(String sid) {
        DBUtil dbUtil = new DBUtil();
        dbUtil.executeUpdate("delete from student where sid = '" + sid + "'");
        dbUtil.close();
    }

    /**
     * 根据 sid 查询学生信息
     * @param sid
     * @return 若存在，则返回正常学生信息，否则null；
     */
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

    /**
     * 返回表中所有元素
     * @param sql 表名
     * @return null 如果表为空
     */
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
        try {
            while(rs.next()){
                MajorDao majorDao = new MajorDaoImpl();
                sid = rs.getString("sid");
                sname = rs.getString("sname");
                gender = rs.getString("gender");
                age = rs.getInt("age");
                mid = rs.getString("mid");
                String mname = majorDao.getByMid(mid).getMname();
                birthday = rs.getString("birthday");
                stus.add( new Student(sid,sname,gender,age,birthday,mname));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        db.close();
        return stus;
    }
}
