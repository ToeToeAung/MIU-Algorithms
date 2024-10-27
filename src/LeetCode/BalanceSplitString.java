package LeetCode;

public class BalanceSplitString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = balancedStringSplit( "RLRRLLRLRL");
		System.out.println("Result is "+result);
	}

	public static int balancedStringSplit(String s) {
		int result=0,balance =0;
		for(char ch:s.toCharArray()) {
			if(ch=='R') balance++;
			else balance --;
			if(balance == 0) result++;
		}			
		return result;		
	}
}
