package learning.java8;

import java.util.Arrays;
import java.util.List;

/**
 * Iterable�ӿ��������forEach�����������Ĳ�����Consumer����һ��lamada���ʽ
 * lamada���ʽ���÷�
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
