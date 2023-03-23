package cn.edu.hit.dao.impl;

import cn.edu.hit.dao.MajorDao;
import cn.edu.hit.db.DBUtil;
import cn.edu.hit.entity.Major;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MajorDaoImpl implements MajorDao {

    @Override
    public Major getByMid(String mid) {
        DBUtil db = new DBUtil();
        String mname = null;

        try{
            ResultSet rs = db.executeQuery("select * from major where mid = '" + mid + "'");
            while(rs.next()){
                mname = rs.getString("mname");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.close();
        }

        return new Major(mid,mname);
    }

    @Override
    public List<Major> getAll(String sql) {
        DBUtil db = new DBUtil();
        List<Major> majors = new ArrayList<>();

        String mid = null;
        String mname = null;

        try{
            ResultSet rs = db.executeQuery("select * from major");
            while(rs.next()){
                mid = rs.getString("mid");
                mname = rs.getString("mname");

                majors.add(new Major(mid,mname));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return majors;
    }
}
