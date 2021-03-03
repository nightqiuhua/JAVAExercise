package atguigu.senior.day15;


import org.junit.Test;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * ResultSet：结果集。封装了使用JDBC进行查询的结果。
 * 1. 调用Statement对象的executeQuery(sql)方法
 * 2. ResultSet返回的实际上就是一张数据表。有一个指针指向数据表的第一行的前面。
 * 可以调用next()方法检测下一行是否有效。若有效，该方法返回true，且指针下移。
 * 相当于Iterator对象的hasNext()和next()方法的结合体
 * 3. 当指针对应到一行时，可以通过嗲用getXXX(index)或getXXX(columnName)获取
 * 每一列的值。如：getInt(1)，getString("name")
 * 4. 关闭ResultSet
 */
public class TestStatement1 {

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
    public void testResultSet(){
        // 获取各项记录，并打印
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;

        try{
            // 1. 获取Connection
            conn = getConnection();

            // 2. 获取Statement
            statement = conn.createStatement();


            // 3. 准备SQL
            String sql = "select id, temp from temps";

            // 4. 执行查询，得到ResultSet
            rs = statement.executeQuery(sql);

            // 5. 处理ResultSet
            while(rs.next()){
                String id = rs.getString(1);
                String temp = rs.getString(2);
                System.out.println(id + "---->"+temp);
            }

            // 6. 关闭数据库资源

        } catch (Exception e){
            e.printStackTrace();
        }finally {
            TestStatement1.release(rs,statement,conn);
        }

    }
}
