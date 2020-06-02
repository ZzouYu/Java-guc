package AbstractFactory.product;

public class XiaomiFactory implements Iproduct {
    @Override
    public IphoneProduct createPhone() {
        return new XiaomiPhone();
    }

    @Override
    public IrouteProduct createRoute() {
        return new XiaomiRoute();
    }
}
