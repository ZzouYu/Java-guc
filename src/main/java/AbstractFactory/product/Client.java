package AbstractFactory.product;

/**
 * @author zouyu
 * @description
 * @date 2020/5/21
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("=====小米产品=====");
        new XiaomiFactory().createPhone().call();
        new XiaomiFactory().createRoute().openWifi();

        System.out.println("=====一加产品=====");
        new YijiaFactory().createPhone().call();
    }
}
