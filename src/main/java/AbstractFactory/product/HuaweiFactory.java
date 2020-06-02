package AbstractFactory.product;

public class HuaweiFactory implements Iproduct {
    @Override
    public IphoneProduct createPhone() {
        return new HuaweiPhone();
    }

    @Override
    public IrouteProduct createRoute() {
        return new HuaweiRoute();
    }
}
