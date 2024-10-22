package LeetCode;
import java.util.ArrayList;
import java.util.List;
public class Subset {

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		
		List<List<Integer>> list=subsets(nums);
//		   for(List<Integer> l : list) {
//			   for(Integer num : l) {
//				   System.out.println("Numbers " + num);
//			   }
//		   }
	}
	
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> arrList = new ArrayList<>();
        backtrack(nums, 0, arrList, result);
        return result;
    }

	 private static void backtrack(int[] nums, int start, List<Integer> arrList, List<List<Integer>> result) {
		 	result.add(new ArrayList<>(arrList));
	        for (int i = start; i < nums.length; i++) {
	        //	System.out.println("Backtrack i index * " +nums[i]);
	        	arrList.add(nums[i]);
	            backtrack(nums, i + 1, arrList, result);
	          //  int size = arrList.size() - 1;
	          //  System.out.println("Backtrack size * " +size);
	            arrList.remove(arrList.size() - 1);
	        }
	    }
}
