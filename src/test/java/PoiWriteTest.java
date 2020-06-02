import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @author zouyu
 * @description
 * @date 2020/6/2
 */
public class PoiWriteTest {

    private static String  path = "D:\\Java-guc\\";

    /**
     * 03最多只能写65536行，否则会抛出异常,后缀xls
     * 测试速度
     * 优点：过程中写入缓存，不操作磁盘，最后一次性写入磁盘，速度快
     */
    @Test
    public void testWrite03BigData() throws Exception {
        long begin = System.currentTimeMillis();
        //创建工作簿 相当于数据库
       Workbook workbook = new HSSFWorkbook();
       //相当于创建一个表
       Sheet sheet = workbook.createSheet("zouyu");
        for (int rowNum = 0; rowNum <65536 ; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum  = 0; cellNum  < 10; cellNum ++) {
                Cell cell = row.createCell(cellNum );
                cell.setCellValue(cellNum);
            }
        }
        OutputStream outputStream = new FileOutputStream(path + "zouyuTest.xls");
        workbook.write(outputStream);
        outputStream.close();
        long end = System.currentTimeMillis();
        System.out.println((double) (end-begin)/1000);//花了多少秒
    }
    /**
     * 测试07版数据量无限制，速度会慢,后缀  xlsx
     * 测试速度
     * 缺点：写数据时速度非常慢，非常耗内存，也会发生内存溢出，如100万条
     * 优点：可以写较大的数据量，如20万条
     */
    @Test
    public void testWrite07BigData() throws Exception {
        long begin = System.currentTimeMillis();
        //创建工作簿 相当于数据库
        Workbook workbook = new XSSFWorkbook();
        //相当于创建一个表
        Sheet sheet = workbook.createSheet("zouyu");
        for (int rowNum = 0; rowNum <65536 ; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum  = 0; cellNum  < 10; cellNum ++) {
                Cell cell = row.createCell(cellNum );
                cell.setCellValue(cellNum);
            }
        }
        OutputStream outputStream = new FileOutputStream(path + "zouyuTest07.xlsx");
        workbook.write(outputStream);
        outputStream.close();
        long end = System.currentTimeMillis();
        System.out.println((double) (end-begin)/1000);//花了多少秒
    }

    /**
     * 大文件写SXSSF
     *     优点：可以写非常大的数据量，如100万条甚至更多条，写数据速度快，占用更少的内存
     *     注意：
     *     过程中会产生临时文件，需要清理临时文件
     *     默认由100条记录被保存在内存中，如果超过这数量，则最前面的数据被写入临时文件
     *     如果想自定义内存中数据的数量，可以使用new SXSSFWorkbook ( 数量 )
     * @throws Exception
     */
    @Test
    public void testWrite07BigDataS() throws Exception {
        long begin = System.currentTimeMillis();
        //创建工作簿 相当于数据库
        Workbook workbook = new SXSSFWorkbook();
        //相当于创建一个表
        Sheet sheet = workbook.createSheet("zouyu");
        for (int rowNum = 0; rowNum <65536 ; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum  = 0; cellNum  < 10; cellNum ++) {
                Cell cell = row.createCell(cellNum );
                cell.setCellValue(cellNum);
            }
        }
        OutputStream outputStream = new FileOutputStream(path + "zouyuTest07s.xlsx");
        workbook.write(outputStream);
        outputStream.close();
        long end = System.currentTimeMillis();
        System.out.println((double) (end-begin)/1000);//花了多少秒
    }
}
