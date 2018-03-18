package learning.singleton;

/**
 * �ڲ���ʵ�ֵ���ģʽ
 * @author Administrator
 *
 */
public class SingletonInner {

	private static class LazyHolder{
		private static final SingletonInner instance = null;
	}
	
	private SingletonInner(){}
	
	public static final SingletonInner getInstance(){
		return LazyHolder.instance;
	}
}
