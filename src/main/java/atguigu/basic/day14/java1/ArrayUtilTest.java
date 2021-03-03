package atguigu.basic.day14.java1;

public class ArrayUtilTest {
    public static void main(String[] args) {
        int[] arr = new int[]{32,34,32,5,3,54,654,-98,0,-53,5};
        int max = ArrayUtil.getMax(arr);
        System.out.println("最大值为：" + max);

        System.out.println("排序前：");
        ArrayUtil.print(arr);

        ArrayUtil.sort(arr);
        System.out.println("排序后：");
        ArrayUtil.print(arr);

    }
}
