package atguigu.senior.day06.exer;

import org.junit.Test;

public class StringDemo {

    /*
    将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反转为”abfedcg”

    方式一：转换为char[]
     */

    public String reverse(String str,int startIndex,int endIndex){
        if(str != null){
            char[] arr = str.toCharArray();
            for(int i=startIndex,j=endIndex;i<j;i++,j++){
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

            }
            return new String(arr);

        }
        return null;


    }

    public String reverse1(String str,int startIndex,int endIndex){
        if(str != null){
            //第1部分
            String reverseStr = str.substring(0,startIndex);

            //第2部分
            for(int i=endIndex;i >= startIndex;i--){
                reverseStr += str.charAt(i);
            }

            //第3部分
            reverseStr += str.substring(endIndex+1);
            return reverseStr;

        }
        return null;
    }

    //方式三：使用StringBuffer/StringBuilder替换String
    public String reverse2(String str,int startIndex,int endIndex){
        if(str != null){
            StringBuilder builder = new StringBuilder();
            //第1部分
            builder.append(str.substring(0,startIndex));

            //第2部分
            for(int i= endIndex; i>=startIndex;i--){
                builder.append(str.charAt(i));
            }

            //第3部分
            builder.append(str.substring(endIndex+1));
            return new String(builder);
        }
        return null;

    }
    @Test
    public void test(){
        String str = "abcdefg";
        String reverse = reverse2(str, 2, 5);
        System.out.println(reverse);
    }

}
