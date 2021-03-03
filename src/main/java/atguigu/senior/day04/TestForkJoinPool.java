package atguigu.senior.day04;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class TestForkJoinPool {
    public static void main(String[] args) {
        Instant start = Instant.now();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new  ForkJoinSumCalculate(0L, 50000000000L);
        Long sum = pool.invoke(task);


        Instant end = Instant.now();
        System.out.println("耗费时间为：" + Duration.between(start, end).toMillis());//166-1996-10590
    }

}


class ForkJoinSumCalculate extends RecursiveTask<Long>{
    private static final long serialVersionUID = -259195479995561737L;
    private long start;
    private long end;

    private static final long THURSHOLD = 10000L;  //临界值

    public ForkJoinSumCalculate(long start,long end){
        this.start = start;
        this.end = end;
    }


    protected Long compute(){
        long length = end - start;
        if(length <= THURSHOLD){
            long sum = 0L;

            for(long i =start;i<=end;i++){
                sum += i;
            }
            return sum;
        } else{
            long middle = (start+end)/2;

            ForkJoinSumCalculate left = new ForkJoinSumCalculate(start,middle);
            left.fork();

            ForkJoinSumCalculate right = new ForkJoinSumCalculate(middle+1,end);
            right.fork();

            return left.join() + right.join();

        }

    }

}