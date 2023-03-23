package cn.edu.hit.dao.impl;

import cn.edu.hit.dao.LoginDao;
import cn.edu.hit.db.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDaoImpl implements LoginDao {
    @Override
    public boolean login(String uid, String pwd) {
        DBUtil db = new DBUtil();

        String sql = "select count(*) from admin where sid = '" + uid + "'and pwd = '" + pwd + "'";
        ResultSet rs = db.executeQuery(sql);

        int count = 0;
        try {
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            db.close();
            return count == 1 ? true : false;
        }
    }
}
