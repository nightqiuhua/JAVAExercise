package atguigu.senior.day04;

public class TestThread8Monitor {
    public static void main(String[] args) {
        final Number number = new Number();
        final Number number2 = new Number();

        new Thread(new Runnable() {
            public void run() {
                number.getOne();
            }
        }
        ).start();

        new Thread(new Runnable() {
            public void run() {
                number2.getTwo();
            }
        }).start();


    }

}

class Number{
    public static synchronized void getOne(){
        try {
            Thread.sleep(3000);
        } catch(InterruptedException e) {
        }

        System.out.println("one");
    }

    public synchronized void getTwo(){
        System.out.println("two");
    }

    public synchronized void getThree(){
        System.out.println("three");
    }

}