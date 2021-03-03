package atguigu.senior.day04;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestThreadPool {
    public static void main(String[] args) {
        ExecutorService pool =  Executors.newFixedThreadPool(5);
        List<Future<Integer>> list = new ArrayList<Future<Integer>>();

        for(int i=0;i<10;i++){
            Future<Integer> future = pool.submit(new Callable<Integer>() {
                public Integer call() throws Exception {
                    int sum = 0;
                    for(int i=0;i<=100;i++){
                        sum+=i;
                    }
                    return sum;
                }
            });
            list.add(future);
        }

        pool.shutdown();

       // for(Future<Integer> future:list){
        //    System.out.println(future.get());
       // }
    }

}

class ThreadPoolDemo implements Runnable{
    private int i =0;

    public void run(){
        while (i <=100){
            System.out.println(Thread.currentThread().getName()+" : " + i++);
        }
    }
}