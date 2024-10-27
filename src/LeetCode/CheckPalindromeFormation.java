package LeetCode;

public class CheckPalindromeFormation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "toe";
		String s2 ="eot";
		boolean isPalindrome =checkPalindromeFormation(s1,s2);
		
		System.out.println("Is Palindrome "+isPalindrome);
	}
	static boolean checkPalindrome(String x, int i, int j) {
	        while (i < j) {
	            if (x.charAt(i) != x.charAt(j)) {
	                break;
	            }
	            i++;
	            j--;
	        }
	        if (i - j >= 0) {
	            return true;
	        }
	        return false;
	    }
	    
	   static boolean  isPalindrome(String a, String b) {
	        int i = 0, j = b.length() - 1;
	        for (; i < j; i++, j--) {
	            if (a.charAt(i) != b.charAt(j)) {
	                break;
	            }
	        }
	        return checkPalindrome(a, i, j) || checkPalindrome(b, i, j);
	        
	    }
	   
	    public static boolean checkPalindromeFormation(String a, String b) {
	       return isPalindrome(a, b) || isPalindrome(b, a);
	    }

}
