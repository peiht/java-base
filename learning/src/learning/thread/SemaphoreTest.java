package learning.thread;

import java.util.concurrent.Semaphore;

/**
 * semaphore�ź��������Կ����̵߳���Դ
 * ����ʮ���߳���Դ����15���߳�Ҫʹ�ã���ô����semaphore��acquire��releaseȥ���ƣ��൱����һ����
 * @ClassName: SemaphoreTest
 * @Description: TODO(���Ҫ�����������Ծ��Ϊ����)
 * @author Administrator
 * @date 2018��3��22��
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
        //semaphore�Ĺ�������int�͵Ĳ�����ʾһ����acquire�����߳�
        Semaphore semaphore = new Semaphore(5);
        
        for(int i=0;i<N;i++) {
            new Workers(i,semaphore).start();
        }
        
      
    }

}
