package AbstractFactory.product;

/**
 * @author zouyu
 * @description
 * @date 2020/5/21
 */
public class XiaomiPhone implements IphoneProduct {
    @Override
    public void call() {
        System.out.println("小米手机打电话");
    }

    @Override
    public void sendSms() {
        System.out.println("小米手机发短信");
    }
}
