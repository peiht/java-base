package alm;

public class QuickSort {

	/**
	 * ��������
	 * ���������п���һ�����飬�ѵ����λ�ÿ������ᣬ�����һ���ȣ��������С���������������κδ����������Ժ��ٺ�С���Ƕ˱ȣ�����С�������������󽻻���
	 * ����ѭ��������һ��������ɣ���߾��Ǳ�����С�ģ��ұ߾��Ǳ������ģ�Ȼ�����÷��η����ֱ�������������������������
	 * @param numbers
	 * @param low
	 * @param high
	 * @return
	 */
	public static int getMiddle(int[] numbers, int low, int high)
	{
		int temp = numbers[low];
		while(low < high)
		{
			while(low < high && numbers[high] > temp)
			{
				high--;
			}
			numbers[low] = numbers[high];
			while(low < high && numbers[low] < temp)
			{
				low++;
			}
			numbers[high] = numbers[low];
		}
		numbers[low] = temp;
		return low;
	}
	
	public static void quickSort(int[] numbers, int low, int high)
	{
		if(low < high)
		{
			int middle = getMiddle(numbers,low,high);
			quickSort(numbers,low,middle-1);
 			quickSort(numbers,middle+1,high);
		}
  	}
	public static void main(String[] agrs)
	{
		int[] numbers = {2,1,4,5,7,3,6};
		quickSort(numbers,0,numbers.length-1);
		for(int i=0;i<numbers.length;i++)
		{
			System.out.println(numbers[i]);
		}
	}
}
