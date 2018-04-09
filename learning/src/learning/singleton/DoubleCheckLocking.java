package learning.singleton;
/**
 * Ë«ÖØÐ£ÑéËø
 * @author Administrator
 *
 */
public class DoubleCheckLocking {
	private static DoubleCheckLocking instance;
	
	private DoubleCheckLocking(){}
	
	public static DoubleCheckLocking getInstance(){
		if(instance == null)
		{
			synchronized(DoubleCheckLocking.class){
				if(instance == null)
				{
					instance = new DoubleCheckLocking();
				}
			}
		}
		return instance;
	}
	
	public static void main(String[] agrs) {
	    DoubleCheckLocking instance = getInstance();
	    DoubleCheckLocking instance2 = getInstance();
	    System.out.println(instance == instance2);
	}
}
