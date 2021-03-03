package atguigu.basic.day05;

public class PrimeNumberTest {
    public static void main(String[] args) {
        boolean isFlag = true;
        for(int i=2;i <= 100;i++){
            for(int j=2;j<i;j++){
                if(i%j == 0){
                    isFlag = true;
                }
            }
            if(isFlag == true){
                System.out.println(i);
            }
            //重置isFlag
            isFlag = true;
        }
    }
}
