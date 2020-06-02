package DymicProxy;

import StaticProxy.Host;
import StaticProxy.Renct;

/**
 * @author zouyu
 * @description
 * @date 2020/5/24
 */
public class Client {
    private  static final boolean aaa = false;
    public static void main(String[] args) {
     /*   Host host = new Host();
        ProxyInvocationHander pih = new ProxyInvocationHander();
        pih.setTarget(host);
        Renct proxy = (Renct) pih.getProxy();
        proxy.renct();*/
       // System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");/
        ProxyLambda proxyLambda = new ProxyLambda();
        Renct bind = proxyLambda.bind(new Host());
        bind.renct();
    }
}
