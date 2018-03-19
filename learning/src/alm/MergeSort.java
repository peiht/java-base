package alm;

import java.util.Arrays;

/**
 * 归并排序
 * @ClassName: MergeSort
 * @Description: TODO(类简要描述，必须以句号为结束)
 * @author Administrator
 * @date 2018年3月17日
 */
public class MergeSort {

    public static void merge(int[] a ,int low ,int mid, int high) {
        int temp[] = new int[high - low + 1];
        int i = low;//左指针
        int j = mid + 1;//右指针
        int k = 0;
        while(i <= mid && j <= high) {
            if(a[i] < a[j]) {
                temp[k++] = a[i++];
            }else {
                temp[k++] = a[j++];
            }
        }
        
        while(i <= mid ) {
            temp[k++] = a[i++];
        }
        
        while(j <= high) {
            temp[k++] = a[j++];
        }
        
        for(int k2 = 0;k2 < temp.length; k2++) {
            a[k2 + low ] = temp[k2];
        }
    }
    
    public static void mergeSort(int[] a ,int low ,int high) {
        int mid = low+(high - low)/2;
        if(low < high) {
            mergeSort(a,low,mid);
            mergeSort(a,mid+1,high);
            merge(a,low,mid,high);
            System.out.println(Arrays.toString(a));
        }
    }
    
    public static void main(String[] args) {
        int a[] = {12,3,1,44,23,53,14,9};
        mergeSort(a,0,a.length-1);
        System.out.println("排序结果为:  "+Arrays.toString(a));
    }

}
