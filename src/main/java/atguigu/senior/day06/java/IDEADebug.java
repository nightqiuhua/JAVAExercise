package atguigu.senior.day06.java;

import org.junit.Test;

public class IDEADebug {
    @Test
    public void testStringBuffer(){
        String s1 = null;
        StringBuffer sb = new StringBuffer();
        sb.append(s1);
        System.out.println(sb.length());//4

        System.out.println(sb);

        StringBuffer sb1 = new StringBuffer(s1);//java.lang.NullPointerException
        System.out.println(sb1);



    }
}
