package atguigu.basic.day12.exer1;

public class Cylinder extends Circle {
    private double length;

    public Cylinder(){
        length = 1.0;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double findVolume(){
        return super.findArea()*getLength();
    }

    @Override
    public double findArea(){
        return Math.PI * getRadius() * getRadius() * 2 +
                2 * Math.PI * getRadius() * getLength();
    }
}
