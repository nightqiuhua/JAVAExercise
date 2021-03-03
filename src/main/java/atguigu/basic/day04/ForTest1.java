package atguigu.basic.day04;

public class ForTest1 {
    public static void main(String[] args) {
        for(int i=1;i<=150;i++){
            System.out.println(i + " ");
            if(i % 3 ==0){
                System.out.print("foo ");
            }

            if(i%5 == 0){
                System.out.print("biz ");
            }

            if(i%7 == 0){
                System.out.print("baz ");
            }


            //换行
            System.out.println();
        }

    }
}
