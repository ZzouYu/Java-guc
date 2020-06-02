package DymicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zouyu
 * @description
 * @date 2020/5/24
 */
public class ProxyLambda {

    public <T> T bind(T t) {
        return (T) Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces()
                , (proxy, method, args) -> {
            System.out.println("代理前");
                    Object result = method.invoke(t, args);
                    return result;
                });
    }
}