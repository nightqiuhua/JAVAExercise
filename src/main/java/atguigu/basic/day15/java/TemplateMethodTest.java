package atguigu.basic.day15.java;

public class TemplateMethodTest {
    public static void main(String[] args) {
        BankTemplateMethod btm = new DrawMoney();
        btm.process();

        BankTemplateMethod btm2 = new ManageMoney();
        btm2.process();

    }
}

abstract class BankTemplateMethod{
    // 具体方法
    public void takeNumber(){
        System.out.println("取号排队");
    }

    public abstract void transact();

    public void evaluate(){
        System.out.println("反馈评分");
    }

    // 模板方法，把基本操作组合到一起，子类一般不能重写
    public final void process(){
        this.takeNumber();
        this.transact();
        this.evaluate();
    }


}

class DrawMoney extends BankTemplateMethod{
    public void transact(){
        System.out.println("我要取款！！！");
    }
}

class ManageMoney extends BankTemplateMethod{
    public void transact(){
        System.out.println("我要理财！我这里有2000万美元!!");
    }
}