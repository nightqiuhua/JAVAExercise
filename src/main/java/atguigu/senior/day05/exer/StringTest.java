package atguigu.senior.day05.exer;

/**
 * 一道面试题
 * @author shkstart
 * @create 2019 上午 11:32
 */
public class StringTest {
    String str1 = new String("good");
    char[] ch = {'t','e','s','t'};

    public void change(String str1,char[] ch){
        str1 = "test ok";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringTest ex = new StringTest();
        ex.change(ex.str1,ex.ch);
        System.out.println(ex.str1);//"good";
        System.out.println(ex.ch);//best

    }

}
