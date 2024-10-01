package W1D1Tutorials;

public class W1D1Lab2 {

	public static void main(String[] args) {
	
	}
	
	public static boolean isPalindrone(String s) {
		int left = 0;
		int right = s.length() -1;
		
		while(left < right ) {
			if(s.charAt(left) != s.charAt(right)) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isPalindroneIntArray(int[] arr) {
		
		int left = 0;
		int right = arr.length-1;
		
		while(left < right) {
			if(arr[left] != arr[right]) {
				return false;
			}
		}
		return true;
	}
	
	
	public static boolean isPalindroneIntArraySameParity(int[] arr) {
		
		int left = 0;
		int right = arr.length-1;
		
		while(left < right) {
			if(arr[left] %2 != arr[right]% 2 ) {
				return false;
			}
		}
		return true;
	}
	
}
