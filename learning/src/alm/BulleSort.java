package alm;

public class BulleSort {

	/**
	 * ð�������ʵ��
	 * ���ڵ�����֮����бȽϣ����������һ���ͽ���λ��
	 * @param numbers
	 */
	public static void bulleSort(int[] numbers){
		int temp = 0;
		int size = numbers.length;
		for(int i=0; i<size-1; i++)
		{
			for(int j=0; j<size-2; j++)
			{
				if(numbers[j] > numbers[j+1])
				{
					temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
				}
			}
		}
		for(int a =0;a<size-1;a++){
			System.out.println(numbers[a]);
		}
	}
	
	
	public static void main(String[] args) {
		int[] test = {11,33,444,5,66,7};
		bulleSort(test);
	}

}
