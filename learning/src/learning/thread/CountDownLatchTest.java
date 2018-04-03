package learning.thread;

import java.util.concurrent.CountDownLatch;
/**
 * CountDownLatch的用法，执行多个线程，可以当做计数器用，等多个线程执行完再调用await方法执行其他线程
 * @ClassName: CountDownLatchTest
 * @Description: TODO(类简要描述，必须以句号为结束)
 * @author Administrator
 * @date 2018年3月22日
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        
        //设置两个线程
       final CountDownLatch latch = new CountDownLatch(2);
       
       new Thread() {
           public void run() {
               try {
                   System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                   Thread.sleep(3000);
                   System.out.println("子线程"+Thread.currentThread().getName()+"执行结束");
                   latch.countDown();
               }catch(Exception e) {
                   e.printStackTrace();
               }
           }
       }.start();
       
       new Thread() {
           public void run() {
               try {
                   System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                   Thread.sleep(10000);
                   System.out.println("子线程"+Thread.currentThread().getName()+"执行结束");
                   latch.countDown();
               }catch(Exception e) {
                   e.printStackTrace();
               }
           }
       }.start();
       
       try {
           System.out.println("等待2个子线程执行完毕");
           //等待两个子线程执行完毕再去往下执行
           latch.await();
           System.out.println("2个子线程执行完毕");
           System.out.println("继续执行主线程");
       }catch(InterruptedException e) {
           e.printStackTrace();
       }
    }

}
