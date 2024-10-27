package LeetCode;

public class NumberofWaysSplitString {

	public static void main(String[] args) {
		String input ="1001";
		int numWays=numWays(input);
		System.out.println("Number of ways "+ numWays);

	}
    public static int numWays(String s) {
        long n=s.length();
        long one=0;// Need to count number of ones
        long mod=1_000_000_007;
        char[] c=s.toCharArray();
        for(int i=0;i<c.length;i++)
        {
            if(c[i]=='1')
                one++;
        }       
             
        //long nminusone= n-1;
       // long nminustwo = n-2;
       // long result = (nminusone * nminustwo)/2;
       // System.out.println("Mod Value =" + mod);
       // System.out.println("n-1 ****" +nminusone + " - "+ nminustwo + " result = "+result);
        if(one==0)
        {
        	
            return (int)((((n-1)*(n-2))/2)%mod);
        }
        
        if(one%3!=0)
            return 0;
       
        long ones=one/3;
        one=0;
        long part1=0;
        long part2=0;
        for(int i=0;i<c.length;i++)
        {
            if(c[i]=='1')
                one++;
            if(one==ones)
                part1++;
            if(one==2*ones)
                part2++;
        }
        
        return (int)((part1*part2)%mod);
    }
}
