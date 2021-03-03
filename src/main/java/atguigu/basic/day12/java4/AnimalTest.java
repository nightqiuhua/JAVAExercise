package atguigu.basic.day12.java4;

import java.sql.Connection;

public class AnimalTest {
    public static void main(String[] args) {
        AnimalTest test = new AnimalTest();
        test.func(new Dog());

    }

    public void func(Animal animal){
        animal.eat();
        animal.shout();
        if(animal instanceof Dog){
            Dog d = (Dog)animal;
            d.watchDoor();
        }
    }
}

class Animal{
    public void eat(){
        System.out.println("动物：进食");
    }

    public void shout(){
        System.out.println("动物：叫");
    }
}

class Dog extends Animal{
    public void eat(){
        System.out.println("狗吃骨头");
    }

    public void shout(){
        System.out.println("汪！汪！汪！");
    }

    public void watchDoor(){
        System.out.println("看门");
    }
}

class Cat extends Animal{
    public void eat(){
        System.out.println("猫吃鱼");
    }

    public void shout(){
        System.out.println("喵！喵！喵！");
    }
}
//举例二：
class Order{
    public void method(Object obj){

    }
}

//举例三：
class Driver{
    public void doData(Connection conn){//conn = new MySQlConnection(); / conn = new OracleConnection();
        //规范的步骤去操作数据
//		conn.method1();
//		conn.method2();
//		conn.method3();

    }
}

