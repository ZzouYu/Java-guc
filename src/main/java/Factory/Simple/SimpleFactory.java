package Factory.Simple;

/** 简单工厂模式（静态工厂模式）
 * @author zouyu
 * 如果在增加车，这里也要做出修改，违反了开闭原则
 * @date 2020/5/21
 */

//开闭原则  在程序需要进行拓展的时候，不能去修改原有的代码，实现一个热插拔的效果。简单来说：就是为了使程序的扩展性好，易于维护和升级。
public class SimpleFactory {
    //方法一
    public static  Car getCar(String name){
        if("五菱".equals(name)){
            return new Wuling();
        }else if("宝马".equals(name)){
            return new Baoma();
        }else {
            return null;
        }
    }

    //方法二
    public Car getWulling(){
        return new Wuling();
    }
}
