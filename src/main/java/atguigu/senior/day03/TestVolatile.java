package atguigu.senior.day03;

class ThreadDemo implements Runnable{

    private volatile boolean flag = false;
    public void run(){
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }

        flag = true;
        System.out.println("flag"+ isFlag());
    }

    public boolean isFlag(){
        return flag;
    }

    public void setFlag(boolean flag){
        this.flag = flag;
    }

}

public class TestVolatile {
    public static void main(String[] args) {
        ThreadDemo td = new ThreadDemo();
        Thread t1 = new Thread(td);

        t1.start();

        while(true){
            if(td.isFlag()){
                System.out.println("------------------");
                break;
            }
        }


    }

}
