package Single;

/**
 * @author zouyu
 * @description
 * @date 2020/5/25
 */
//线程安全
public class LazySingle {
    private static volatile  LazySingle s= null;  //防止指令重拍
    private LazySingle(){

    }

    public static LazySingle getInstance(){
        if(s == null){
            synchronized (LazySingle.class){
                if(s==null){
                    s= new LazySingle();
                }
            }
        }
        return  s;
    }

    public static void main(String[] args) {
        System.out.println(LazySingle.getInstance().hashCode());
        System.out.println(LazySingle.getInstance().hashCode());
    }
}
