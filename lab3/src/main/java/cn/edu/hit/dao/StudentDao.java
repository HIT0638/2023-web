package cn.edu.hit.dao;

import cn.edu.hit.entity.Student;

import java.util.List;

public interface StudentDao {
    void add(Student stu);
    void modify(Student stu);
    void remove(String sid);
    List<Student> getAll(String sql);
    Student getBySid(String sid);
}
