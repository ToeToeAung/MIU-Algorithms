package LeetCode;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] s = {'t','t','a'};
		reverseString(s);
	}

    public static void reverseString(char[] s) {
        int left =0;
        int right=s.length-1;
       while(left<=right){
           char temp= s[right]; 
           s[right]= s[left];
           s[left]=temp;
           left ++;
           right --;
       }
       for(char ch:s) {
        System.out.println("characters "+ ch);
       }
    }
}
