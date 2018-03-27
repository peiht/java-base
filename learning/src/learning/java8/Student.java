package learning.java8;

public class Student implements Person {

	public static void main(String[] args){
		Student student = new Student();
		String name = student.getName("lalala");
		System.out.println(name);
	}
}
