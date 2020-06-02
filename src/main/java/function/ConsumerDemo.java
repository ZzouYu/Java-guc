package function;

import java.util.function.Consumer;

/**
 * @author zouyu
 * 消费型接口，只有输入，没有返回值
 * @date 2020/5/19
 */
public class ConsumerDemo {
    public static void main(String[] args) {

        Consumer<Double> consumer = new Consumer<Double>() {
            @Override
            public void accept(Double money) {
                System.out.println("每次消费" + money);
            }
        };
        consumer.accept(50.0);
        happy(100,(money)->{System.out.println("每次消费"+money);});
    }

    public static void  happy(double money, Consumer<Double> con){
        con.accept(money);
    }
}
