package AbstractFactory.product;

//抽象工厂只适合增加产品族，不适合增加产品，如还要增加笔记本，那就需要更改所有代码
public interface Iproduct {
    IphoneProduct createPhone();
    IrouteProduct createRoute();
}
