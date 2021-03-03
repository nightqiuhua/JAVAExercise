package atguigu.basic.day06.exer;

import java.lang.reflect.Array;

public class ArrayDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{8,2,1,3,6};
        int[] index = new int[]{2,0,3,0,4,1,3,4};
        String tel = "";
        for(int i=0;i<index.length;i++){
            tel += arr[index[i]];
        }
        System.out.println("联系方式：" + tel);
    }
}
