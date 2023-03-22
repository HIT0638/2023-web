package cn.edu.hit.studentservlet.db;

import java.sql.*;

public class DBUtil {
    public static final String URL = "jdbc:mysql://localhost:3306/hit";
    public static final String USER = "root";
    public static final String PASSWORD = "tb030612";
    private Connection conn;
    private Statement stmt;

    /**
     * 构造函数
     */
    public DBUtil() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.createStatement();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 关闭与数据库的链接
     */
    public void close() {
        try {
            if(!stmt.isClosed()) {
                stmt.close();
            }
            if(!conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 在数据库中查找元素
     * @param sql
     * @return
     */
    public ResultSet executeQuery(String sql) {
        try {
            ResultSet rs = stmt.executeQuery(sql);
            return rs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 更新数据库元素
     * @param sql
     */
    public void executeUpdate(String sql) {
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
