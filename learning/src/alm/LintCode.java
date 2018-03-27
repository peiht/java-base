package alm;

import java.util.ArrayList;
import java.util.List;

public class LintCode {

	public static int digitCounts(int k ,int n){
		String str[] = new String[n+1];
		String find = String.valueOf(k);
		int count = 0;
		char[] array = find.toCharArray();
		for(int i=0;i<n+1;i++){
			char num[] = String.valueOf(i).toCharArray();
			for(int j=0;j<num.length;j++){
				if(num[j] == array[0]){
					count++;
				}
			}
		}
		System.out.println();
		return count;
	}
	
	public static int nthUglyNumber(int n){
		int count = 1;
		int num = 1;
		while(num>0){
			
			if(is(num)){			
				if(n == count){
					//System.out.println(num);
					break;
				}
				count ++;
				num++;
			}else{
				num++;
			}
			}
			return num;
	}
	
	public static boolean is(int num){
		while(num%2 == 0||num%3 == 0||num%5 == 0){
			if(num%2 == 0){
				num = num/2;
			}
			if(num%3 == 0){
				num=num/3;
			}
			if(num%5 == 0){
				num=num/5;
			}
		}
		if(num == 1){
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		int a = nthUglyNumber(1665);
		System.out.println(a);
	}
}
