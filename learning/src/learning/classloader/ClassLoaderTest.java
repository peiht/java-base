package learning.classloader;

/**
 * ����صĲ��裺���ء���֤��׼������������ʼ����ʹ�á�ж�ء�
 * @ClassName: ClassLoaderTest
 * @Description: TODO(���Ҫ�����������Ծ��Ϊ����)
 * @author Administrator
 * @date 2018��3��19��
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
