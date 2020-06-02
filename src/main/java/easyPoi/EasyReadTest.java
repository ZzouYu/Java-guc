package easyPoi;

import com.alibaba.excel.EasyExcel;
import org.junit.Test;

/**
 * @author zouyu
 * @description
 * @date 2020/6/2
 */
public class EasyReadTest {
    private static String  path = "D:\\Java-guc\\";

    @Test
    public void simpleRead() {
        // 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
        // 写法1：
        String fileName = path+ "testread.xls";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).sheet().headRowNumber(2).doRead();
    }
}
