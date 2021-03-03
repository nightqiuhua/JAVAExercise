package atguigu.senior.day02;

class Number implements Runnable{
    private int number =1;
    private Object obj = new Object();

    public void run(){
        while(true){
            synchronized (obj){
                obj.notify();//线程1唤起线程2 or 线程2唤起线程1

                if(number<100){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }else{
                    break;
                }

            }

        }

    }



}

public class CommunicationTest {

    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}
