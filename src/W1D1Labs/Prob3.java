package W1D1Labs;
import java.util.Arrays;

public class Prob3 {
	  public boolean isAnagram(String s, String t) {	      
	        if (s.length() != t.length()) {
	            return false;
	        }
	 
	        char[] sArray = s.toCharArray();
	        char[] tArray = t.toCharArray();

	        Arrays.sort(sArray);
	        Arrays.sort(tArray);
	        
	        return Arrays.equals(sArray, tArray);
	    }
}
