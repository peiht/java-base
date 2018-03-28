package learning.java8;

/**
 * 提供了接口的默认方法，必须用default修饰
 * 如果改接口继承了父接口，则此接口的默认方法会被覆盖
 * 类优先原则
 * @author Administrator
 *
 */
@FunctionalInterface
public interface Person {

	default String getName(String name){
		return name;
	}
	
	String getID();
}
