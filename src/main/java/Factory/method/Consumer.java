package Factory.method;

import Factory.Simple.SimpleFactory;

/**
 * @author zouyu
 * 工厂模式，每个车对应一个工厂方法，增加车需要增加一个工厂方法
 * @date 2020/5/21
 */
public class Consumer {
    public static void main(String[] args) {
        Car car = new BaomaFactory().getCar();
        car.name();
    }
}
