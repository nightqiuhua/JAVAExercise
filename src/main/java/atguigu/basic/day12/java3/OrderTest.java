package atguigu.basic.day12.java3;

import atguigu.basic.day12.java2.Order;

public class OrderTest {
    public static void main(String[] args) {
        Order order = new Order();
        order.orderPublic = 1;
        order.methodPublic();


    }

    public void show(Order order){
        order.orderPublic = 1;
        order.methodPublic();
    }
}
