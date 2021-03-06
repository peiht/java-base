package learning.thread;

import java.util.HashMap;

public class ThreadLocalTest {

    static ThreadLocal<HashMap> map0 = new ThreadLocal<HashMap>() {
        @Override
        protected HashMap initialValue() {
            System.out.println(Thread.currentThread().getName()+"initialValue");
            return new HashMap();
        }
    };
    
    public void run() {
        Thread[] runs = new Thread[3];
        for(int i=0;i<runs.length;i++) {
            runs[i] = new Thread(new T1(i));
        }
        for(int i = 0;i<runs.length;i++) {
            runs[i].start();
        }
    }
    
    public static class T1 implements Runnable{

        int id ;
        public T1(int id0) {
            this.id = id0;
        }
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+":start");
            HashMap map = map0.get();
            for(int i=0;i<10;i++) {
                map.put(i, i+id*100);
                try {
                    Thread.sleep(1000);
                }catch(Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+":"+map);
            }
        }
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ThreadLocalTest test = new ThreadLocalTest();
        test.run();

    }

}
