package cn.edu.hit.dao;

import cn.edu.hit.entity.Major;

import java.util.List;

public interface MajorDao {
    Major getByMid(String mid);
    List<Major> getAll(String sql);
}
