package learning.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
	public static class TestPool implements Runnable{

		@Override
		public void run() {
			System.out.println(System.currentTimeMillis()+"线程ID："+Thread.currentThread().getId());
			try{
				Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) throws InterruptedException{
		TestPool pool = new TestPool();
		ExecutorService es = new ThreadPoolExecutor(5,5,0L,TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(10),Executors.defaultThreadFactory(),
				new RejectedExecutionHandler(){
			
			@Override
			public void rejectedExecution(Runnable arg0, ThreadPoolExecutor arg1) {
				System.out.println("等待线程被拒绝");
				
			}
			
		});
		for(int i=0;i<50;i++)
		{
			es.submit(pool);
			Thread.sleep(10);
		}
	}

}
