package alm;

public class QuickSort {

	/**
	 * 快速排序
	 * 把整个序列看做一个数组，把第零个位置看做中轴，和最后一个比，如果比它小交换，比它大不做任何处理；交换了以后再和小的那端比，比它小不交换，比他大交换。
	 * 这样循环往复，一趟排序完成，左边就是比中轴小的，右边就是比中轴大的，然后再用分治法，分别对这两个独立的数组进行排序。
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
