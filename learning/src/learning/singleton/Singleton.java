package learning.singleton;

/**
 * ¶öººÄ£Ê½
 * @author Administrator
 *
 */
public class Singleton {
	private static Singleton instance = new Singleton();
	
	private Singleton(){}
	
	private static Singleton newInstance(){
		return instance;
	}

}
