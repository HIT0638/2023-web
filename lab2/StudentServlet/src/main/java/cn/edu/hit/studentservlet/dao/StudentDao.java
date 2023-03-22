package cn.edu.hit.studentservlet.dao;

import cn.edu.hit.studentservlet.entity.Student;

import java.util.List;

public interface StudentDao {
    boolean add(Student stu);
    void modify(Student stu);
    void remove(String sid);
    Student getBySid(String sid);
    List<Student> getAll(String sql);
}
