package cn.edu.hit.studentservlet.dao;

import cn.edu.hit.studentservlet.entity.Major;

import java.util.List;

public interface MajorDao {
    Major getByMid(String mid);
    List<Major> getAll(String sql);
}
