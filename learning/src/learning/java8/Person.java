package learning.java8;

/**
 * �ṩ�˽ӿڵ�Ĭ�Ϸ�����������default����
 * ����Ľӿڼ̳��˸��ӿڣ���˽ӿڵ�Ĭ�Ϸ����ᱻ����
 * ������ԭ��
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
