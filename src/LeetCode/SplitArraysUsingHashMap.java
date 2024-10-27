package LeetCode;

import java.util.HashMap;

public class SplitArraysUsingHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {1,1,2,2,3,4};
		boolean split=IsPossibleToSplit(nums);
		System.out.println("Possible? "+split);
	}
public static boolean IsPossibleToSplit(int[] nums) {
	HashMap<Integer,Integer> hMap=new HashMap<>();
	for(int i=0;i<nums.length;i++) {
		System.out.println("Default Value of nums[i] "+hMap.getOrDefault(nums[i], 0));
		hMap.put(nums[i], hMap.getOrDefault(nums[i], 0)+1);
		if(hMap.get(nums[i])>2) 
			return false;
		
	}
	return true;
}
}
