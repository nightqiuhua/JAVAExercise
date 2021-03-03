package atguigu.basic.day08.exer;

public class CircleTest {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        c1.radius = 2.1;

        c1.findArea();


    }
}

class Circle{
    //属性
    double radius;

    public void findArea(){
        double area = Math.PI * radius * radius;
        System.out.println("面积为：" + area);
    }


}