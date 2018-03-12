package learning.singleton;

/**
 * ����ģʽ�ı���
 * @author Administrator
 *
 */
public class SingleTon1 {

	private static SingleTon1 instance = null;
	static{
		instance = new SingleTon1();
	}
	private SingleTon1(){}
	public static SingleTon1 getInstance(){
		return instance;
	}
}
