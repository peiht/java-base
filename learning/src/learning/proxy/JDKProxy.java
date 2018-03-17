package learning.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk�Ķ�̬��������ʹ���˷�����ƣ��������뵽spring��dao��service��Ľӿں�ʵ����ĵ��á�
 * jdk�Ĵ���ֻ���ʵ���˽ӿڵ�����д���gclib����Ե���ļ̳еĴ���
 * @ClassName: JDKProxy
 * @Description: TODO(���Ҫ�����������Ծ��Ϊ����)
 * @author Administrator
 * @date 2018��3��17��
 */
public class JDKProxy implements InvocationHandler {
    //��Ҫ�����Ŀ�����
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
        System.out.println(".:���Ȩ��");
    }

    public static void main(String args[]) {
        JDKProxy jdk  = new JDKProxy();
        UserManager user = (UserManager) jdk.newProxy(new UserManagerImpl());
        user.addUser("1", "123456");
    }
}
