package learning.java8;

public class Student implements Person {

	public static void main(String[] args){
		//Student student = new Student();
		//String name = student.getName("lalala");
		//System.out.println(name);
	    Person person = DefaultFactory.create(Student::new);
	    System.out.println(person.getName("aaa"));
	    
	    //Doctor::new名为方法引用
	    //四种引用方式
	    //Class::new  Class::method  Class::static_method instance::method
	    person = DefaultFactory.create(Doctor::new);
	    System.out.println(person.getName("aaa"));
	}

    @Override
    public String getID() {
        // TODO Auto-generated method stub
        return null;
    }

}
