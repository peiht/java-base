package learning.thread;

import java.util.concurrent.Semaphore;

/**
 * semaphore信号量，可以控制线程的资源
 * 假如十个线程资源，有15个线程要使用，那么久用semaphore的acquire和release去控制，相当于锁一样。
 * @ClassName: SemaphoreTest
 * @Description: TODO(类简要描述，必须以句号为结束)
 * @author Administrator
 * @date 2018年3月22日
 */
public class SemaphoreTest {

    static class Workers extends Thread{
        private int num;
        private Semaphore semaphore;
        public Workers(int num,Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }
        
        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("worker "+this.num+" is working.....");
                Thread.sleep(2000);
                System.out.println("worker "+this.num+" release machine");
                semaphore.release();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        int N = 8;
        //semaphore的构造器，int型的参数表示一下能acquire多少线程
        Semaphore semaphore = new Semaphore(5);
        
        for(int i=0;i<N;i++) {
            new Workers(i,semaphore).start();
        }
        
      
    }

}
