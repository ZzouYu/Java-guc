package easyPoi;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author zouyu
 * @description
 * @date 2020/6/2
 */
@Data
public class ComplexHeadData {
        @ExcelProperty({"主标题", "名称"})
        private String string;
        @ExcelProperty({"主标题", "日期"})
        private Date date;
        @ExcelProperty({"主标题", "金额"})
        private Double doubleData;
        @ExcelProperty({"主标题", "金额2"})
        private Double doubleData2;
    }
