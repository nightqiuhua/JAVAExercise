package atguigu.basic.day12.exer1;

public class Circle {
    private double radius;//半径

    public Circle(){
        radius = 10;
    }

    public Circle(double radius){
        this.radius = 10;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double findArea(){
        return Math.PI*radius*radius;
    }
}
