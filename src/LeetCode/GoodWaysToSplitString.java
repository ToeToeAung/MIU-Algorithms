package LeetCode;

public class GoodWaysToSplitString {

	public static void main(String[] args) {
		int nuSplit=numSplits("aacaba");
		System.out.println("Good Ways To Split String " + nuSplit);

	}
	public static int numSplits(String str) {
	    int left[] = new int[26], right[] = new int[26], d_left = 0, d_right = 0, result = 0;
	    var s = str.toCharArray();
	    for (char ch : s) {
	    	int preIncrement =++right[ch - 'a'];
	    	System.out.println("Pre Increment	" + preIncrement);
	    	System.out.println(" what is **" + ch+   " ** char " + right[ch -'a']);
	    
	    	d_right += ++right[ch - 'a'] == 1 ? 1 : 0;
	    }
	    System.out.println("D Right" +d_right);
	    for (int i = 0; i < s.length; ++i) {
	    	d_left += ++left[s[i] - 'a'] == 1 ? 1 : 0;
	        d_right -= --right[s[i] - 'a'] == 0 ? 1 : 0;
	        result += d_left == d_right ? 1 : 0;
	    }
	    
	    System.out.println("D Right " +d_right + " D Left " +d_left);
	    return result;
	}
}
