package W1D2Labs;
/*Algorithm 1 : Idea – Use three loops one after another. First loop will find Max. Second loop will find Second Max, Third loop will find third max. Note that it is possible First max == second Max == Third Max as in
7, 20, 18, 4, 20, 19, 20, 3.
and your program should return 20 in this case.
*/
public class W1D2 {

	public static void main(String[] args) {
		int[] arr= {4,6,7,8,3,9,10,7,11};
		int firstMax = findFirstMax(arr);
		int secondMax = findSecondMax(arr,firstMax);
		int thirdMax = findThirdMax(arr,secondMax);
		System.out.println("The first max  "+ firstMax + " Second "+ secondMax + " Third " + thirdMax);		
	
		findMax(arr);
	}
	
	
	public static int findFirstMax(int[] arr) {
		int firstMax = Integer.MIN_VALUE;
		
		for(int i=0;i< arr.length;i++) {
			if(arr[i] > firstMax) {
				firstMax = arr[i];
			}
		}
		return firstMax;
	}

	
	public static int findSecondMax(int[] arr, int firstMax) {
		int secondMax = Integer.MIN_VALUE;
				for(int i=0;i< arr.length;i++) {
					if(arr[i] > secondMax && arr[i] < firstMax) {
						secondMax = arr[i];
					}
				}
		
		return secondMax;
	}
	
	public static int findThirdMax(int[] arr, int secondMax) {
		int thirdMax = Integer.MIN_VALUE;
				for(int i=0;i< arr.length;i++) {
					if(arr[i] > thirdMax && arr[i] < secondMax ) {
						thirdMax = arr[i];
					}
				}
		
		return thirdMax;
	}
	
	
	public static void findMax(int[] arr) {
		   int max = Integer.MIN_VALUE;
	        int preMax = Integer.MIN_VALUE;
	        int prePreMax = Integer.MIN_VALUE;
	      
	        for (int i = 0; i < arr.length; i++) {
	            if (arr[i] > max) {	              
	                prePreMax = preMax;
	                preMax = max;
	                max = arr[i];
	            } else if (arr[i] > preMax && arr[i] < max) {	              
	                prePreMax = preMax;
	                preMax = arr[i];
	            } else if (arr[i] > prePreMax && arr[i] < preMax) {	              
	                prePreMax = arr[i];
	            }
	        }
	        System.out.println("******************");
	        System.out.println("First Maximum: " + max);
	        System.out.println("Second Maximum: " + preMax);
	        System.out.println("Third Maximum: " + prePreMax);
	}
	        
}
