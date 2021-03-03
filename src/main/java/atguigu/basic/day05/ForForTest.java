package atguigu.basic.day05;

/*
嵌套循环的使用
1.嵌套循环：将一个循环结构A声明在另一个循环结构B的循环体中,就构成了嵌套循环

2.
外层循环：循环结构B
内层循环：循环结构A

3. 说明
① 内层循环结构遍历一遍，只相当于外层循环循环体执行了一次
② 假设外层循环需要执行m次，内层循环需要执行n次。此时内层循环的循环体一共执行了m * n次

4. 技巧：
   外层循环控制行数，内层循环控制列数
*/
public class ForForTest {
    public static void main(String[] args) {
        for(int i=1;i<=6;i++){
            System.out.println('*');
        }
        System.out.println("\n");

        /*
         ******
         ******
         ******
         ******
         */
        for(int j=1;j<=4;j++){
            for(int i=1;i<=6;i++){
                System.out.print('*');
            }
            System.out.println();
        }

        for(int i = 1;i<=5;i++){
            for(int j=1;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("======================");
        for(int i=1;i<=4;i++){
            for(int j=1;j<=5-i;j++){
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
