package LeetCode;

import java.util.Arrays;

public class SplitNumswithMinimumSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num =4325;
		int result = SplitNumswithMinimumSum(num);
		System.out.println("Result is " + result);
	}
public static int SplitNumswithMinimumSum(int num) {
	char[] chArr = Integer.toString(num).toCharArray();
	Arrays.sort(chArr);
	int num1=0,num2=0;
	boolean flag = true;
	for(char ch: chArr) {
		if(flag) {
		 num1 = num1 * 10 + (ch - '0');
		}else {
		 num2 = num2 * 10 + (ch - '0');
		}	 
		flag = !flag;
	}	
	
	return num1 + num2;
}
}
