package cn.edu.hit.studentservlet.dao;

import cn.edu.hit.studentservlet.entity.Major;

import java.util.List;

public interface MajorDao {
    void add(Major major);
    void modify(Major major);
    void remove(String mid);
    Major getByMid(String mid);
    List<Major> getAll(String sql);
}
