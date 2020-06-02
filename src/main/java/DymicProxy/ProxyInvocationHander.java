package DymicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zouyu
 * @description
 * @date 2020/5/23
 */
public class ProxyInvocationHander implements InvocationHandler {

    private  Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(target, args);
        return invoke;
    }

    //拿到代理实列
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),target.getClass().getInterfaces()
               ,this);
    }
}
