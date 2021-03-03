package atguigu.senior.day15;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.util.Properties;

public class JDBCTest {
    // 编写一个通用的方法，在不修改源程序的情况下，可以获取任何数据库的连接

    public Connection getConnection() throws Exception{
        String driverClass = null;
        String jdbcUrl = null;
        String user = null;
        String password = null;

        // 读取类路径下的jdbc.propertites 文件
        Properties properties = new Properties();
        InputStream in = getClass().getClassLoader().getResourceAsStream("jdbc.properties");
        properties.load(in);
        driverClass = properties.getProperty("driver");
        jdbcUrl = properties.getProperty("jdbcUrl");
        user = properties.getProperty("user");
        password = properties.getProperty("password");

        Driver driver = (Driver) Class.forName(driverClass).newInstance();
        Properties info = new Properties();
        info.put("user",user);
        info.put("password",password);

        Connection connection = driver.connect(jdbcUrl,info);


        //System.out.println(in);
        return connection;


    }

    @Test
    public void testGetConnection() throws Exception {
        System.out.println(getConnection());
    }


}
