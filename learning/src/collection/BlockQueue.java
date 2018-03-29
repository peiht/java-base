package collection;

import java.util.Stack;
//简单实现了一个阻塞队列，可用于并发消息队列，是线程安全的
public class BlockQueue<T> {

	private final static Object pushLock = new Object();
	
	private final static Object popLock = new Object();
	//用栈来当做队列
	private Stack<T> stack;
	
	public BlockQueue(){
		stack = new Stack();
	}
	
	public synchronized void push(T t){
		int MAX_SIZE = 32;
		if(stack.size() >= MAX_SIZE){
			pushLock();
		}
		stack.push(t);
		popUnlock();
	}
	
	public T pop(){
		if(stack.size() == 0){
			popLock();
		}
		//T t = stack.pop();
		T t = stack.get(0);
		stack.remove(0);
		pushUnlock();
		return t;
	}
	
	//给push操作枷锁
	private void pushLock(){
		synchronized(pushLock){
			try {
				pushLock.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//给push解锁
	private void pushUnlock(){
		synchronized(pushLock){
			pushLock.notify();
		}
	}
	
	//给pop操作枷锁
		private void popLock(){
			synchronized(popLock){
				try {
					popLock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		//给pop解锁
		private void popUnlock(){
			synchronized(popLock){
				popLock.notify();
			}
		}
		
	public static void main(String[] args) {
		BlockQueue<String> queue = new BlockQueue<String>();
		queue.push("1");
		queue.push("a");
		queue.push("~~~");
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());

	}

}
