package atguigu.senior.day04;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable {
    public static void main(String[] args) {
        ThreadDemo td = new ThreadDemo();

        //1.执行 Callable 方式，需要 FutureTask 实现类的支持，用于接收运算结果。
        FutureTask<Integer> result = new FutureTask<Integer>(td);

        new Thread(result).start();

        //2.接收线程运算后的结果
        try{
            Integer sum = result.get();
            System.out.println(sum);
            System.out.println("---------------------------------------------");
        }catch ( ExecutionException  e) {
            e.printStackTrace();
        } catch (InterruptedException e ){
            e.printStackTrace();
        }

    }

}

class ThreadDemo implements Callable<Integer>{

    public Integer call() throws Exception{
        int sum =0;
        for(int i=0;i<=1000;i++){
            sum+=1;
        }

        return sum;

    }
}
