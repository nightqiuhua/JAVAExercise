package atguigu.senior.day10.exer2;

        import org.junit.Test;

        import java.io.File;
        import java.io.IOException;

public class FileDemo {
    @Test
    public void test1() throws IOException {
        File file = new File("D:\\guigu\\java_ex\\src\\main\\java\\atguigu\\senior\\day10");
        //创建一个与file同目录下的另外一个文件，文件名为：haha.txt
        File descFile = new File(file.getParent(),"haha.txt");
        boolean newFile = descFile.createNewFile();
        if(newFile){
            System.out.println("创建成功！");
        }

    }
}
