package atguigu.basic.day15.java3;

interface Filial{// 孝顺的
    default void help(){
        System.out.println("老妈，我来救你了");
    }

}

interface Spoony{// 痴情的
    default void help(){
        System.out.println("媳妇，别怕，我来了");
    }

}

class Father{
    public void help(){
        System.out.println("儿子，就我媳妇！");
    }
}


public class Man extends Father implements Filial,Spoony{
    @Override
    public void help() {
        System.out.println("我该就谁呢？");
        super.help();
        Filial.super.help();
        Spoony.super.help();
    }

    public static void main(String[] args) {
        Man p = new Man();
        p.help();
    }
}
