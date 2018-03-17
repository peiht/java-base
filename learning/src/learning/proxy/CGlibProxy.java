package learning.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGlibProxy implements MethodInterceptor {

    private Object targetObject;
    
    public Object createProxyObject(Object obj) {
        this.targetObject = obj;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(obj.getClass());
        enhancer.setCallback(this);
        Object proxyobj = enhancer.create();
        return proxyobj;
    }
    @Override
    public Object intercept(Object object, Method method, Object[] arg2, MethodProxy methodproxy) throws Throwable {
        Object obj = null;
        if("addUser".equals(method.getName())) {
            checkPopedom();
        }
        obj = method.invoke(targetObject, arg2);
        return obj;
    }

    private void checkPopedom() {
        System.out.println("ºÏ≤È»®œﬁ");
    }
    
    public static void main(String agrs[]) {
        UserManager user = (UserManager) new CGlibProxy().createProxyObject(new UserManagerImpl());
        System.out.println("--------cglibproxy-------");
        user.addUser("1", "1234");
    }
}
