package Tutorials;

public class SortingAlgorithms {

	public static void main(String[] args) {
		  int[] A = {5, 8, 10, 15,19,4,7}; 
		  sort(A);
	}
		public static void sort(int[] arr){
		int len = arr.length;
		int temp = 0;
		for(int i = 0; i < len; ++i) {
		int nextMinPos = minpos(arr,i,len-1);
		swap(arr,i,nextMinPos);
		}
		
		 for(int num : arr) {
			 System.out.println(num);
		 }
		}
		
		public static void swap(int[] arr,int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		}
		
		public static int minpos(int[] arr,int bottom, int top){
		int m = arr[bottom];
		int index = bottom;
		for(int i = bottom+1; i <= top; ++i) {
		if(arr[i]<m){
		m=arr[i];
		index=i;
		}
		}
		return index;
		}
}
