package atguigu.basic.day03;


/*
运算符之二：赋值运算符
=  +=  -=  *=  /=  %=


*/
public class SetValueTest {
    public static void main(String[] args) {
        //赋值符号：=
        int i1 =10;
        int j1 = 10;

        int i2,j2;
        //连续赋值
        i2 = j2 = 10;

        int i3 = 10, j3 = 20;

        //*********************
        int num1 = 10;
        num1 += 2;
        System.out.println(num1);

        int num2 = 12;
        num2 %= 5;
        System.out.println(num2);

        int s1 = 10;
        //s1 = s1 + (short)2;//编译失败
        s1 += 2;
        System.out.println(s1);


        //开发中，如果希望变量实现+2的操作，有几种方法？(前提：int num = 10;)
        //方式一：num = num + 2;
        //方式二：num += 2; (推荐)

        //开发中，如果希望变量实现+1的操作，有几种方法？(前提：int num = 10;)
        //方式一：num = num + 1;
        //方式二：num += 1;
        //方式三：num++; (推荐)

        int i = 1;
        i*=.1;
        System.out.println(i);
        i++;
        System.out.println(i);

        //练习2
        int m = 2;
        int n = 3;
        n *= m++;
        System.out.println("m="+m);//3
        System.out.println("n="+n);//6

        //练习3
        int n1 =10;
        n1 += (n1++) + (++n1);//n1 = n1 + (n1++) + (++n1);
        System.out.println(n1);



    }
}
