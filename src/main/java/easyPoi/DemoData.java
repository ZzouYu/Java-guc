package easyPoi;

import com.alibaba.excel.annotation.format.DateTimeFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author zouyu
 * @description
 * @date 2020/6/2
 */
@Data
public class DemoData {
    private String provice;
    private String name;
    private String cata;
    private String level;
    @DateTimeFormat("yyyy-MM-dd")
    private String  date;
    private long doubleData;
}
