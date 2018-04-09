package learning.singleton;

/**
 * �ڲ���ʵ�ֵ���ģʽ
 * @author Administrator
 *
 */
public class SingletonInner {

	private static class LazyHolder{
		private static final SingletonInner instance = new SingletonInner();
	}
	
	private SingletonInner(){}
	
	public static final SingletonInner getInstance(){
		return LazyHolder.instance;
	}
	
	public static void main(String[] args){
		SingletonInner in = getInstance();
		SingletonInner in1 =getInstance();
		System.out.println(in == in1);
	}
}
