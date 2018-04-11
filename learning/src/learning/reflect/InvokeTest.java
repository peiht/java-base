package learning.reflect;

import java.lang.reflect.Method;

public class InvokeTest {

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("learning.reflect.A");
        Object o = clazz.newInstance();
        
        @SuppressWarnings("unchecked")
        Method method = clazz.getMethod("foo",String.class);
        
        for(int i = 0;i<16;i++)
        {
            method.invoke(o,Integer.toString(i));
        }
    }

}
