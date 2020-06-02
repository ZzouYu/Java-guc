package StaticProxy;

/**
 * @author zouyu
 * @description
 * @date 2020/5/23
 */

//抽象角色，真实角色）（房东）  代理角色（中介） 客户端调用
public class Client {
    public static void main(String[] args) {
        Host h =new Host();
        ProxyRenct proxy = new ProxyRenct();
        proxy.setHost(h);
        proxy.renct();
    }
}
