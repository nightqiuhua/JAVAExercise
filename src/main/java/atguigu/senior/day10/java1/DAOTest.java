package atguigu.senior.day10.java1;

import atguigu.senior.day10.java.SubOrder;
import org.junit.Test;

import java.util.List;

public class DAOTest {
    @Test
    public void test1(){
        CustomerDAO doa1 = new CustomerDAO();

        doa1.add(new Customer());
        List<Customer> list = doa1.getForList(10);

        StudentDAO dao2 = new StudentDAO();
        Student student = dao2.getIndex(1);

    }
}
