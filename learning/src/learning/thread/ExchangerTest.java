package learning.thread;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/**
 * 两个线程之间数据的交换，一个线程把data放到exchanger中，另一个线程再读取
 * 如果读取的线程没有取到数会一直阻塞到有数，或者一个线程产生数会一直阻塞到其他线程取数
 * @ClassName: ExchangerTest
 * @Description: TODO(类简要描述，必须以句号为结束)
 * @author Administrator
 * @date 2018年4月4日
 */
public class ExchangerTest {

    public static volatile boolean isDone = false;
    
    static class ExchangerProducer implements Runnable{

        private Exchanger<Integer> exchanger;
        
        private static int data = 1;
        
        ExchangerProducer(Exchanger<Integer> exchanger){
            this.exchanger = exchanger;
        }
        
        @Override
        public void run() {
            while(!Thread.interrupted() && !isDone){
                for(int i=1;i<=3;i++) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        data = i;
                        System.out.println("producer before:"+data);
                        data = exchanger.exchange(data);
                        System.out.println("producer after:"+data);
                    }catch(Exception e) {
                        e.printStackTrace();
                    }
                }
                isDone = true;
            }
        }
        
    }
    
    static class ExchangerConsumer implements Runnable{
        private Exchanger<Integer> exchanger;
        private static int data = 0;
        ExchangerConsumer(Exchanger<Integer> exchanger){
            this.exchanger = exchanger;
        }
        
        @Override
        public void run() {
            while(!Thread.interrupted() && !isDone) {
                data = 0;
                System.out.println("consumer before:"+data);
                try {
                    TimeUnit.SECONDS.sleep(1);
                    data = exchanger.exchange(data);
                }catch(Exception e) {
                    e.printStackTrace();
                }
                System.out.println("consumer after:"+data);
            }
            
        }
        
    }
    
    public static void main(String[] args) {
        ExecutorService exe = Executors.newCachedThreadPool();
        Exchanger<Integer> exchanger = new Exchanger<Integer>();
        ExchangerProducer producer = new ExchangerProducer(exchanger);
        ExchangerConsumer consumer = new ExchangerConsumer(exchanger);
        exe.execute(producer);
        exe.execute(consumer);
        exe.shutdown();
        try {
            exe.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
