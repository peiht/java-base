package learning.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier类的使用，当设置的barrier的线程数都打到await的状态时开始往下执行
 * CyclicBarrier可以复用就是当做计数器时，下一个线程的还会继续使用，countdownlatch则不可以
 * @ClassName: CyclicBarrierTest
 * @Description: TODO(类简要描述，必须以句号为结束)
 * @author Administrator
 * @date 2018年4月3日
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        int N = 4;
        CyclicBarrier cyclic = new CyclicBarrier(N);
        for(int i=0;i<N;i++) {
            new Writer(cyclic).start();;
        }
    }
    
    static class Writer extends Thread{
        private CyclicBarrier cyclicBarrier;
        
        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }
        
        @Override
        public void run() {
            System.out.println("线程"+Thread.currentThread().getName()+"正在写入数据.....");
            try {
                Thread.sleep(5000);
                System.out.println("线程"+Thread.currentThread().getName()+"写入线程完毕，等待其他线程执行完");
                //等待所有的线程都返回barrier之后，才会继续往下执行
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("所有线程写入完成");
        }
    }
}
