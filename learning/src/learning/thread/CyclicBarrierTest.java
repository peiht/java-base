package learning.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier���ʹ�ã������õ�barrier���߳�������await��״̬ʱ��ʼ����ִ��
 * CyclicBarrier���Ը��þ��ǵ���������ʱ����һ���̵߳Ļ������ʹ�ã�countdownlatch�򲻿���
 * @ClassName: CyclicBarrierTest
 * @Description: TODO(���Ҫ�����������Ծ��Ϊ����)
 * @author Administrator
 * @date 2018��4��3��
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
            System.out.println("�߳�"+Thread.currentThread().getName()+"����д������.....");
            try {
                Thread.sleep(5000);
                System.out.println("�߳�"+Thread.currentThread().getName()+"д���߳���ϣ��ȴ������߳�ִ����");
                //�ȴ����е��̶߳�����barrier֮�󣬲Ż��������ִ��
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("�����߳�д�����");
        }
    }
}
