package learning.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/**
 * Condition类有await方法和signal方法，一个是阻塞一个是唤醒
 * @author Administrator
 *
 */
class MyService{
	private ReentrantLock lock = new ReentrantLock();
	private Condition conditionA  = lock.newCondition();
	private Condition conditionB = lock.newCondition();
	
	public void methodA()
	{
		lock.lock();
		try{
			System.out.println("MethodA begins ThreadName = "+ Thread.currentThread().getName()+" "+System.currentTimeMillis());
			conditionA.await();
			System.out.println("MethodA ends ThreadName = "+ Thread.currentThread().getName()+" "+System.currentTimeMillis());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	
	public void methodB()
	{
		lock.lock();
		try{
			System.out.println("MethodB begins ThreadName = "+ Thread.currentThread().getName()+" "+System.currentTimeMillis());
			conditionB.await();
			System.out.println("MethodB ends ThreadName = "+ Thread.currentThread().getName()+" "+System.currentTimeMillis());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	
	public void signalA()
	{
		lock.lock();
		conditionA.signal();
		lock.unlock();
	}
	
	public void signalA_All()
	{
		lock.lock();
		conditionA.signalAll();
		lock.unlock();
	}
	
	public void signalB()
	{
		lock.lock();
		conditionB.signal();
		lock.unlock();
	}
	
	public void signalB_All()
	{
		lock.lock();
		conditionB.signalAll();
		lock.unlock();
	}
}

class ThreadA extends Thread{
	private MyService service;
	ThreadA(MyService service){
		this.service = service;
	}
	public void run(){
		service.methodA();
	}
}

class ThreadB extends Thread{
	private MyService service;
	ThreadB(MyService service){
		this.service = service;
	}
	public void run(){
		service.methodB();
	}
}

public class ConditionTest {

	public static void main(String[] args) throws InterruptedException {
		MyService service = new MyService();
		ThreadA threadA = new ThreadA(service);
		threadA.setName("A");
		
		ThreadB threadB = new ThreadB(service);
		threadB.setName("B");
		
		threadA.start();
		threadB.start();
		
		Thread.sleep(1000);
		service.signalA();
		Thread.sleep(1000);
		service.signalB();
	}

}
