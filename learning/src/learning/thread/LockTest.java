package learning.thread;

import java.util.concurrent.locks.ReentrantLock;

class MyThread extends Thread{
	private LockTest test;
	public MyThread(LockTest test){
		this.test = test;
	}
	public void run(){
		test.method();
	}
}
/**
 * synchronizedִ�е��Ǳ���������������ȫ�и�jvm��
 * @author Administrator
 *
 */
public class LockTest {

    private String name;
    public LockTest(String name) {
        this.name = name;
    }
    public LockTest() {}
	private ReentrantLock lock = new ReentrantLock();
	
	public void method(){
		try {
			lock.lock();
			for(int i=0;i<3;i++)
				{
				Thread.sleep(1000);
				System.out.println("threadname = "+name+ Thread.currentThread());
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				lock.unlock();
			}
	}
	public static void main(String[] args) {
		LockTest test = new LockTest("  aaaaa   ");
		MyThread thread1 = new MyThread(test);
		MyThread thread2 = new MyThread(test);
		
		thread2.start();
		thread1.start();
	}

}
