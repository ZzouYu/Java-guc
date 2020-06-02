import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author zouyu
 * @description
 * @date 2020/5/22
 */

public class MainTest {
    Byte[]  ch =new Byte[1*1024*1024];
    public static void main(String[] args) throws IOException {

      /*  List list = new ArrayList<>();
        while (true){
            list.add(new MainTest());
        }*/
    /*    System.out.println(SessionUtils.getUser());
        System.out.println(SessionUtils.getUser());*/

    }
    @Test
    public void test(){
        Properties p = new Properties();
        try {
            InputStream in = getClass().getResourceAsStream("a.properties");
            p.load(in);
            System.out.println(p.getProperty("user.name"));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
        }
    }
}
