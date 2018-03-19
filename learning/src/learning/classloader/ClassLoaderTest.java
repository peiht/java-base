package learning.classloader;

/**
 * 类加载的步骤：加载、验证、准备、解析、初始化、使用、卸载。
 * @ClassName: ClassLoaderTest
 * @Description: TODO(类简要描述，必须以句号为结束)
 * @author Administrator
 * @date 2018年3月19日
 */
public class ClassLoaderTest {

	public static void main(String[] args) {
		ClassLoader loader = ClassLoaderTest.class.getClassLoader();
		while(loader != null){
			System.out.println(loader.toString());
			loader = loader.getParent();
		}

	}

}
