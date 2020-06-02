package Factory.Simple;

/**
 * @author zouyu
 * 简单工厂，买车的人，只想通过名字就能拿到车，而不是自己去建造,不用关心细节，从工厂中获取
 * @date 2020/5/21
 */

//应用  spring容器管理bean  反射newinstance jdbc获取connection对象
public class Consumer {
    public static void main(String[] args) {
        Car car1 = SimpleFactory.getCar("宝马");
        car1.name();
    }
}
