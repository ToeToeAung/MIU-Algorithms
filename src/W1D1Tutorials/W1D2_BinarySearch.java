package W1D1Tutorials;

public class W1D2_BinarySearch {

	public static void main(String[] args) {
		int[] bArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 7;

        int result = BinarySearch(bArray, target);

        if (result != -1) {
            System.out.println("Target value  " + target + " found at index: " + result);
        } else {
            System.out.println("Target value " + target + " not found in the array.");
        }
	}
	
	public static int BinarySearch(int[] arr,int target) {
		
		int left  = 0;
		int right = arr.length -1;
		while(left <= right) {
			int mid = left + (right -left) /2;
			if(target == arr[mid]){
				return mid;
			}else if(target > arr[mid]) {
				left = mid + 1;
			}else {
				right = mid -1;
			}
			
		}
		return -1;
	}

}
