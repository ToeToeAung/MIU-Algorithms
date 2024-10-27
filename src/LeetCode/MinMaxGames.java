package LeetCode;

public class MinMaxGames {

	public static void main(String[] args) {
		
		int[] nums = {1,3,5,2,4,8,2,2};
		int result =minMaxGame(nums);
		System.out.println("MinMax " +result);
	}
    public static int minMaxGame(int[] nums) {
        int N = nums.length;
       while((N/=2) >= 1)
       {
           for(int i = 0; i < N; i++)
           {
        	   int value = i&1;
        	   System.out.println("i & 1 ->" + value );
               if((i&1) == 0) 
                   nums[i] = Math.min(nums[2*i],nums[2*i+1]);
               else 
                   nums[i] = Math.max(nums[2*i],nums[2*i+1]);
           }
       }
       return nums[0];
   }
}
