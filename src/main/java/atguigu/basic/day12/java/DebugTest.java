package atguigu.basic.day12.java;

public class DebugTest {
    public static void main(String[] args) {
        int i = 10;
        int j = 20;
        System.out.println("i = " + i + ", j = " + j);

        DebugTest test = new DebugTest();
        int max = test.getMax(i,j);
        System.out.println("max = " + max);

    }

    private int getMax(int k,int m){
        int max = 0;
        if(k > m){
            max = k;
        }else {
            max = m;
        }
        return max;
    }
}
