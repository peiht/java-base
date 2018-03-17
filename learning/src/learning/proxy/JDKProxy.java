package learning.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk的动态代理方法，使用了反射机制，可以联想到spring到dao和service层的接口和实现类的调用。
 * jdk的代理只针对实现了接口的类进行代理，gclib是针对的类的继承的代理。
 * @ClassName: JDKProxy
 * @Description: TODO(类简要描述，必须以句号为结束)
 * @author Administrator
 * @date 2018年3月17日
 */
public class JDKProxy implements InvocationHandler {
    //需要代理的目标对象
    private Object targetObject;
    
    public Object newProxy(Object targetObject) {
        this.targetObject = targetObject;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        checkPopedom();
        Object ret = null;
        ret = method.invoke(targetObject, args);
        return ret;
    }
    
    private void checkPopedom() {
        System.out.println(".:检察权限");
    }

    public static void main(String args[]) {
        JDKProxy jdk  = new JDKProxy();
        UserManager user = (UserManager) jdk.newProxy(new UserManagerImpl());
        user.addUser("1", "123456");
    }
}
