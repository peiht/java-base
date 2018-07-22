package learning.classloader;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class Reference {
    public static void main(String[] args){
        ReferenceTest test = new ReferenceTest("12345");
        WeakReference<ReferenceTest> weakReference = new WeakReference<ReferenceTest>(test);
        test  = weakReference.get();
        System.out.println(test.getClass());

        WeakHashMap weakHashMap = new WeakHashMap();
    }
}
