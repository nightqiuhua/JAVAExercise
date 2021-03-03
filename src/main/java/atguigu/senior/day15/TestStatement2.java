package atguigu.senior.day15;

import org.junit.Test;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class TestStatement2 {
    Connection conn = null;
    PreparedStatement ps = null;


    public  Connection getConnection() throws Exception{
        // 1. 准备连接数据库的4个字符串。
        // 1.1 创建Properties对象
        Properties properties = new Properties();

        // 1.2 获取jdbc.properties对应的输入流
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("jdbc.properties");

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
    @Test
    public void testPreparedStatement(){


       try{
           conn = getConnection();
           String sql = "insert into temps (id, temp) values(?,?)";
           ps = conn.prepareStatement(sql);
           ps.setString(1,"sensor_55555");
           ps.setDouble(2,5.99999);
           ps.executeUpdate();
       } catch (Exception e){
           e.printStackTrace();
       }finally {
           TestStatement2.release(ps,conn);
       }

    }


}
