package AbstractFactory.product;

/**
 * @author zouyu
 * @description
 * @date 2020/5/21
 */
public class HuaweiRoute implements IrouteProduct {
    @Override
    public void openWifi() {
        System.out.println("打开华为WIFI");
    }
}
