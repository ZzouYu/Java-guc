import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;

/**
 * @author zouyu
 * POI-Excel读
 * @date 2020/6/2
 */
public class PoiReadTest {
    private static String  path = "D:\\Java-guc\\";
    @Test
    public void testCellType() throws Exception {
          //先获取文件流
        InputStream inputStreamn = new FileInputStream(path + "testread.xls");
        //先拿到工作簿 //可以根据传过来的后缀名，来使用03 还是07
        Workbook workbook = new HSSFWorkbook(inputStreamn);
        // 拿到计算公司 eval
        FormulaEvaluator formulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook)workbook);
        //这里可以抛出异常
        if(workbook == null) {
            return;
        }
        //得到第一个sheet 也相当于表
        Sheet sheet = workbook.getSheetAt(0);
        //先获取标题
        Row rowTitle = sheet.getRow(0);
        //有多少列
        int cellNums = rowTitle.getPhysicalNumberOfCells();
        //有多少行
        int rowCount = sheet.getPhysicalNumberOfRows();
        if (rowTitle!=null) {
            readExcelTitle(rowTitle,cellNums);
        }
        //读取表格内容
        readExcelContent( rowCount, sheet,cellNums,formulaEvaluator);
        inputStreamn.close();
    }
    //读取标题,可以根据要求返回
    public void readExcelTitle(Row rowTitle,int cellNums){
        for (int cellNum = 0; cellNum < cellNums; cellNum++) {
            Cell cell = rowTitle.getCell(cellNum);
            if (cell!=null){
                String cellValue = cell.getStringCellValue();
                System.out.print(cellValue + " | ");
            }
        }
        System.out.println("");
    }
    //读取表格中的数据,可以根据要求返回
    public void readExcelContent(int rowCount,Sheet sheet,int cellNums, FormulaEvaluator formulaEvaluator){
        for (int rowNum = 1; rowNum < rowCount ; rowNum++) {
            Row rowData = sheet.getRow(rowNum);
            if(null!=rowData){
                int rowsize = 0;
                for (int cellNum = 0; cellNum < cellNums; cellNum++) {
                    Cell cell = rowData.getCell(cellNum);
                    if (cell!=null){
                        String value = readExcelValue(cell, formulaEvaluator);
                    }else{
                        if( null == cell) {
                            rowsize+=1;
                        }
                    }
                }
                //防止脏读
                if(rowsize == cellNums){
                    break;
                }
            }
            System.out.println("------");
        }
    }
    public String readExcelValue( Cell cell,FormulaEvaluator formulaEvaluator){
        String cellValue = "";
        int cellType = cell.getCellType();
         switch (cellType){
             case Cell.CELL_TYPE_STRING:  //字符串
                 cellValue = cell.getStringCellValue();
                 System.out.print(cellValue+"|");
                 break;
             case Cell.CELL_TYPE_BOOLEAN: //布尔
                 cellValue = String.valueOf(cell.getBooleanCellValue());
                 System.out.print(cellValue+"|");
                 break;
             case Cell.CELL_TYPE_BLANK://空值
                 cellValue = "";
                 System.out.print(cellValue+"|");
                 break;
             case Cell.CELL_TYPE_ERROR:
                 cellValue = "非法字符";
                 System.out.print(cellValue+"|");
                 break;
             case Cell.CELL_TYPE_NUMERIC:  //数字分为时间和数字
                  if(DateUtil.isCellDateFormatted(cell)){ //日期
                      Date date = cell.getDateCellValue();
                      cellValue = new DateTime(date).toString("yyyy-MM-dd");
                  }else{
                      // 不是日期格式，防止数字过长！ 转化为字符串输出
                      cell.setCellType(Cell.CELL_TYPE_STRING);
                      cellValue = cell.toString();
                  }
                  System.out.print(cellValue+"|");
                  break;
             case Cell.CELL_TYPE_FORMULA: // 公式
                 // 计算
                 String formula = cell.getCellFormula();
                 CellValue evaluate = formulaEvaluator.evaluate(cell);
                 cellValue = evaluate.formatAsString();
                 System.out.print(cellValue+"|");
                 break;
         }
         return cellValue;
    }

}
