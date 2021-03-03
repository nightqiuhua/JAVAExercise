package atguigu.senior.day01;

class HelloThread extends Thread {
    @Override
    public void run(){
        for(int i=0;i<100;i++){
            if(i%2 == 0){

                try {
                    sleep(10);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName()+":"+i);
            }

            if(i%20 == 0){
                yield();
            }

        }
    }

    public HelloThread(String name){
        super(name);
    }

}

public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloThread t1 = new HelloThread("Thread:1");
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);

        for(int i=0;i<100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getPriority()+":"+i);
            }
        }

    }
}
