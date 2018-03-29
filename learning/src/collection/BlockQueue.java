package collection;

import java.util.Stack;
//��ʵ����һ���������У������ڲ�����Ϣ���У����̰߳�ȫ��
public class BlockQueue<T> {

	private final static Object pushLock = new Object();
	
	private final static Object popLock = new Object();
	//��ջ����������
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
	
	//��push��������
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
	//��push����
	private void pushUnlock(){
		synchronized(pushLock){
			pushLock.notify();
		}
	}
	
	//��pop��������
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
		//��pop����
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
