package W1D4Labs;

public class W1D4 {

	public static void main(String[] args) {
		int step=ClimbStairs(10);
		System.out.println("Number of steps " +step);
	}
	  public static int ClimbStairs(int n) {
	      if(n <= 2 )
	          return n;
	       
	        int a=1;
	        int b=2;
	        for(int i=3;i<=n;i++){
	            int sum = a + b;
	            a = b;
	            b = sum;
	        }
	        return b;
	    }
	  
}
