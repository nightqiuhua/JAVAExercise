package atguigu.senior.day03;

import java.util.concurrent.atomic.AtomicInteger;

class AtomicDemo implements Runnable{
    private AtomicInteger serialNumber = new AtomicInteger(0);

    public void run(){
        try{
            Thread.sleep(200);
        } catch (InterruptedException e){

        }
        System.out.println(getSeriaNumber());

    }

    public int getSeriaNumber(){
        return serialNumber.getAndIncrement();
    }

}

public class TestAtomicDemo {
    public static void main(String[] args) {
        AtomicDemo ad = new AtomicDemo();
        for(int i=0;i<10;i++){
            new Thread(ad).start();
        }
    }
}
