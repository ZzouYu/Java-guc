package AbstractFactory.product;

/**
 * @author zouyu
 * @description
 * @date 2020/5/21
 */
public class YijiaFactory implements  Iproduct {
    @Override
    public IphoneProduct createPhone() {
        return new YijiaPhone();
    }

    @Override
    public IrouteProduct createRoute() {
        return new YijiaRoute();
    }


}
