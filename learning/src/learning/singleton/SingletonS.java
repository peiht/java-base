package learning.singleton;

public class SingletonS {

	private static SingletonS instance = null;
	
	private SingletonS(){}
	
	public synchronized static SingletonS newInstance(){
		if(null == instance){
			instance = new SingletonS();
		}
		return instance;
	}
	
	public static void main(String[] args){
		SingletonS ss = new SingletonS();
		ss.newInstance();
	}
}
