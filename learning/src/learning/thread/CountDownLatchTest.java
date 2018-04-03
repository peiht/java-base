package learning.thread;

import java.util.concurrent.CountDownLatch;
/**
 * CountDownLatch���÷���ִ�ж���̣߳����Ե����������ã��ȶ���߳�ִ�����ٵ���await����ִ�������߳�
 * @ClassName: CountDownLatchTest
 * @Description: TODO(���Ҫ�����������Ծ��Ϊ����)
 * @author Administrator
 * @date 2018��3��22��
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        
        //���������߳�
       final CountDownLatch latch = new CountDownLatch(2);
       
       new Thread() {
           public void run() {
               try {
                   System.out.println("���߳�"+Thread.currentThread().getName()+"����ִ��");
                   Thread.sleep(3000);
                   System.out.println("���߳�"+Thread.currentThread().getName()+"ִ�н���");
                   latch.countDown();
               }catch(Exception e) {
                   e.printStackTrace();
               }
           }
       }.start();
       
       new Thread() {
           public void run() {
               try {
                   System.out.println("���߳�"+Thread.currentThread().getName()+"����ִ��");
                   Thread.sleep(10000);
                   System.out.println("���߳�"+Thread.currentThread().getName()+"ִ�н���");
                   latch.countDown();
               }catch(Exception e) {
                   e.printStackTrace();
               }
           }
       }.start();
       
       try {
           System.out.println("�ȴ�2�����߳�ִ�����");
           //�ȴ��������߳�ִ�������ȥ����ִ��
           latch.await();
           System.out.println("2�����߳�ִ�����");
           System.out.println("����ִ�����߳�");
       }catch(InterruptedException e) {
           e.printStackTrace();
       }
    }

}
