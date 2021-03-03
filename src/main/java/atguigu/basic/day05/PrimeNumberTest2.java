package atguigu.basic.day05;


/*
100000以内的所有质数的输出。实现方式二
质数：素数，只能被1和它本身整除的自然数。-->从2开始，到这个数-1结束为止，都不能被这个数本身整除。

对PrimeNumberTest.java文件中质数输出问题的优化
*/
public class PrimeNumberTest2 {
    public static void main(String[] args) {
        int count = 0;
        //获取当前时间距离1970-01-01 00:00:00 的毫秒数
        long start = System.currentTimeMillis();

        label:for(int i=2;i<=100000;i++){
            for(int j=2;j<= Math.sqrt(i);i++){
                if(i%j == 0){
                    continue label;
                }
            }
            count++;
        }
        //获取当前时间距离1970-01-01 00:00:00 的毫秒数
        long end = System.currentTimeMillis();
        System.out.println("质数的个数为：" + count);
        System.out.println("所花费的时间为：" + (end - start));//17110 - 优化一：break:1546 - 优化二：13


    }
}
