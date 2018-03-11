package learning.thread;

/**
 * 1、使用volatile关键字之后，变量如发生改变会强制写入内存。共享的变量对其他线程来说是可见的
 * 2、禁止了指令的重排序。
 * @author Administrator
 *
 */
public class VolatileTest {
	public volatile int inc = 0;
	
	public void increase(){
		inc++;
	}

	public static void main(String[] args) {
		final VolatileTest test =  new VolatileTest();
		for(int i=0;i<10;i++)
		{
			new Thread(){
				public void run(){
					for(int j=0;j<1000;j++)
					{
						test.increase();
					}
				}
			}.start();
		}
		while(Thread.activeCount() > 1)
		{
			Thread.yield();
		}
		System.out.println(test.inc);
	}

}
