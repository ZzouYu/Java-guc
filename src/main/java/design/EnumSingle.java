package design;

/**
 * @author zouyu
 * @description
 * @date 2020/5/21
 */
//单列模式应用   整个系统只需要一个对象
    //数据库连接池   线程池   spring默认配置的bean 操作系统的文件系统 网站的计数器
public enum EnumSingle {
    SINGLE;
    public EnumSingle getSingle(){
        return SINGLE;
    }

    public static void main(String[] args) {
        EnumSingle.SINGLE.getSingle();
    }
}
