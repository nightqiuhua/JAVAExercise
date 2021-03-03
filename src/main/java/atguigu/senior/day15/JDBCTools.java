package atguigu.senior.day15;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author: Li Tian
 * @contact: litian_cup@163.com
 * @software: IntelliJ IDEA
 * @file: JDBCUtils.java
 * @time: 2020/3/21 15:23
 * @desc: |操作JDBC的工具类，其中封装了一些工具方法
 * Version1
 */
public class JDBCTools {
    /**
     * 关闭Statement和Connection的方法
     */
    public static void release(Statement statement, Connection conn){
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (statement != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void release(ResultSet rs, Statement statement, Connection conn){
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (statement != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 1. 获取连接的方法
     * 通过读取配置文件从数据库服务器获取一个连接。
     *
     * @return
     */

    public static Connection getConnection() throws Exception{
        // 1. 准备连接数据库的4个字符串。
        // 1.1 创建Properties对象
        Properties properties = new Properties();

        // 1.2 获取jdbc.properties对应的输入流
        InputStream in = JDBCTools.class.getClass().getClassLoader().getResourceAsStream("jdbc.properties");

        // 1.3 加载1.2对应的输入流
        properties.load(in);

        // 1.4 具体决定user，password等4个字符串。
        String driverClass = properties.getProperty("driver");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String jdbcUrl = properties.getProperty("jdbcUrl");

        // 2. 加载数据库驱动程序
        Class.forName(driverClass);

        // 3. 通过DriverManager的getConnection()方法获取数据库连接。
        Connection connection = DriverManager.getConnection(jdbcUrl,user,password);
        return connection;
    }

    public void update(String sql){
        Connection conn = null;
        Statement statement = null;
        try{
             conn = getConnection();
             statement = conn.createStatement();
            statement.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCTools.release(statement,conn);
        }
    }

    public static void rollback(Connection conn){
        try {
            conn.rollback();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void commit(Connection conn) throws SQLException {
        conn.commit();
    }
}
