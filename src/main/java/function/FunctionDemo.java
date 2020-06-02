package function;

import java.util.function.Function;

/**
 * @author zouyu
 * Function  功能型接口，一个输入，一个输出参数
 * @date 2020/5/19
 */
public class FunctionDemo {
    public static void main(String[] args) {

        /*Function<String, String> function = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s;
            }
        };*/

//        Function<String, String> function = (str)->{return str.trim();};
//        System.out.println(function.apply("aa00"));
        System.out.println(strHandler("asda    ", str -> {
            return str.trim();
        }));

    }
   //定义一个处理字符串的方法
    public static String strHandler(String str,Function<String,String> fun){
        return fun.apply(str);
    }
}
