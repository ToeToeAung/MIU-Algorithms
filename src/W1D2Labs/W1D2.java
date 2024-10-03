package W1D2Labs;
import java.util.TreeMap;
/*
 *Question 1. Comparing Algorithms. Problem: Find the THIRD largest in an array.
Algorithm 1 : Idea – Use three loops one after another. First loop will find Max. Second loop will find Second Max, Third loop will find third max. Note that it is possible First max == second Max == Third Max as in
7, 20, 18, 4, 20, 19, 20, 3.
and your program should return 20 in this case.
Algorithm 2 : Idea – Use one loop. Maintain three variable max, preMax and prePreMax such that max will have the maximum value, preMax will have the second largest and prePreMax will have the third largest value.
Algorithm 3 : Idea – Use an ordered dictionary.
In this lab, for every algorithm you will
(a)
write the pseudo code. (Must follow the notations and conventions used in today’s Lecture)
(b)
determine the worst-case time complexity by counting as in Slide 15 Lesson 2.
(c) Perform an empirical time comparison by implementing using Java, similar to what you did in W1D1.
Draw a chart to compare all algorithms.
*/
public class W1D2 {

	public static void main(String[] args) {
		int[] arr= {7, 20, 18, 4, 20, 19, 20, 3};
		int thirdMaxIn3Loop = findThirdMaxUsingThreeLoop(arr);
		System.out.println("The Third maximum value Using Three Loop is  "+ thirdMaxIn3Loop);			
		
		 System.out.println("******************");	
		int thirdMaxInOneLoop = findThirdMaxUsingOneLoop(arr);
		System.out.println("The Third maximum value Using One Loop is  "+ thirdMaxInOneLoop);		
		
		
		 System.out.println("******************");
		 int thirdMaxUsingDict = findThirdMaxUsingTreeMap(arr);
			System.out.println("The Third maximum value Using Dictionary is  "+ thirdMaxUsingDict);		
		
	}
    public static int findThirdMaxUsingThreeLoop(int[] A) {
       int max1 = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] > max1) {
                max1 = A[i];
            }
        }
     
     //   System.out.println("Max 1 *" + max1);
        
        int max2 = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > max2 && A[i] < max1) {
                max2 = A[i];
            }
        }
      //  System.out.println("Max 2 *" + max2);
        
        int max3 = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > max3 && (A[i] < max2)) {
                max3 = A[i];
            }
        }

        return max3;
    }
			
	public static int findThirdMaxUsingOneLoop(int[] arr) {
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
	        
	    return prePreMax > 0 ? prePreMax : max;
	}
	
	public static int findThirdMaxUsingTreeMap(int[] arr) {	      
	        TreeMap<Integer, Integer> map = new TreeMap<>();
	        
	        for (int value : arr) {
	            map.put(value, map.getOrDefault(value, 0) + 1);
	        }
	  
	        Object[] keys = map.descendingKeySet().toArray();
	      
	        if (keys.length >= 3) {
	            return (int) keys[2]; 
	        } else {
	          
	            return (int) keys[0];
	        }
	    }
	
	        
}
