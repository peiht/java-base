package learning.classloader;

public class ClassLoaderTest {

	public static void main(String[] args) {
		ClassLoader loader = ClassLoaderTest.class.getClassLoader();
		while(loader != null){
			System.out.println(loader.toString());
			loader = loader.getParent();
		}

	}

}
