package bridge;

/**
 * @author zouyu
 * @description
 * @date 2020/5/22
 */
//电脑类通过组合关系 建立与品牌的桥
///java 的跨平台性
public  abstract class Computer {

    protected  Brand brand;
    public Computer (Brand brand){
        this.brand = brand;
    }
     public  void info(){
         brand.info();   //自带品牌信息
     }
}


//w为了方便写在了同一个类里面
class DeskTop extends Computer{

    public DeskTop(Brand brand) {
        super(brand);
    }

    @Override
    public  void info(){
        super.info();
        System.out.print("台式") ;
    }


}
class NoteBook extends Computer{

    public NoteBook(Brand brand) {
        super(brand);
    }

    @Override
    public  void info(){
        super.info();
        System.out.print("笔记本") ;
    }
}