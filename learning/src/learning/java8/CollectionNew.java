package learning.java8;

import java.util.Arrays;
import java.util.List;

/**
 * Iterable接口中添加了forEach方法，方法的参数是Consumer，是一个lamada表达式
 * lamada表达式的用法
 * (param) -> expression
 * (param) -> statement
 * (parma) -> {statement}
 * @author Administrator
 *
 */
public class CollectionNew {

	public static void main(String[] agrs){
		List features = Arrays.asList("Lamada","Default Method","data and time","Stream");
		String separator = ",";
		//features.forEach(n -> System.out.println(n+separator));
		
		//features.forEach(System.out::println);
	}
}
