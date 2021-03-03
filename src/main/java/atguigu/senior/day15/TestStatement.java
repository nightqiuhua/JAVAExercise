package atguigu.senior.day15;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 通过JDBC向指定的数据表中插入一条记录
 * 1. Statement：用于执行sql语句的对象
 * 1.1 通过Connection的createStatement()方法来获取
 * 1.2 通过executeUpdate(sql)可以执行SQL语句
 * 1.3 传入的sql可以是insert, update或delete，但不能是select
 * 2. Connection、Statement都是应用程序和数据库服务器的连接资源。使用后一定要关闭。
 * 2.1 需要再finally中关闭
 * 3. 关闭顺序：先获取的后关，后获取的先关
 */
public class TestStatement {
    Connection conn = null;
    Statement statement = null;
    @Test
    public void testStatement(){
        try{
            // 1. 获取数据库连接
            conn = getConnection2();
            // 2. 准备插入的SQL语句
            String sql = "insert into temps (id, temp) values('sensor_3333', 2.358653)";
            String sql2 = "update temp set temp=5.9999 where id = 'sensor_4'";

            // 3. 执行插入
            // 3.1 获取操作sql语句的Statement对象
            statement = conn.createStatement();

            // 3.2 调用Statement对象的executeUpdate(sql)执行SQL语句
            statement.executeUpdate(sql);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    // 4. 关闭Statement对象
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (statement != null) {
                    // 5. 关闭Connection对象
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

/**
 * 通用的更新的方法：insert/update/delete
 * 版本1
 */

    public void update(String sql){
        Connection conn = null;
        Statement statement = null;

        try {
            conn = getConnection2();
            statement = conn.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception e){
            e.printStackTrace();
        }finally {
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

    }
    @Test
    public void test1(){
        String sql = "insert into temps (id, temp) values('sensor_444', 9.999999)";
        update(sql);
    }

    public Connection getConnection2() throws Exception {
        // 1. 准备连接数据库的4个字符串。
        // 1.1 创建Properties对象
        Properties properties = new Properties();
        // 1.2 获取jdbc.properties对应的输入流
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("jdbc.properties");
        // 1.3 加载1.2对应的输入流
        properties.load(in);
        // 1.4 具体决定user，password等4个字符串。
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String jdbcUrl = properties.getProperty("jdbcUrl");
        String driver = properties.getProperty("driver");
        // 2. 加载数据库驱动程序
        Class.forName(driver);
        // 3. 通过DriverManager的getConnection()方法获取数据库连接。
        return DriverManager.getConnection(jdbcUrl, user, password);
    }


}
