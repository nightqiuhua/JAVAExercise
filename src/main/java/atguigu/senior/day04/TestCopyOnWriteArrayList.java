package atguigu.senior.day04;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class HelloThread implements Runnable{
    private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();

    static{
        list.add("AA");
        list.add("BB");
        list.add("CC");
    }

    public void run(){
        Iterator<String> it = list.iterator();

        while (it.hasNext()){
            System.out.println(it.next());
            list.add("AA");
        }


    }

}


public class TestCopyOnWriteArrayList {
    public static void main(String[] args) {
        HelloThread h1 = new HelloThread();

        for(int i=0;i<10;i++){
            new Thread(h1).start();
        }


    }



}
