package W1D1Labs;

public class Prob3_Test {

	public static void main(String[] args) {
		
		Prob3 prob3 = new Prob3();
        // Test case 1: Anagram 
        String s1 = "anagram";
        String t1 = "nagaram";
        System.out.println("Test Case 1: " + s1 + " and " + t1 + " -> " + prob3.isAnagram(s1, t1)); 

        // Test case 2: Not anagram 
        String s2 = "dig";
        String t2 = "dog";
        System.out.println("Test Case 2: " + s2 + " and " + t2 + " -> " + prob3.isAnagram(s2, t2)); 

        // Test case 3: Anagram
        String s3 = "listen";
        String t3 = "silent";
        System.out.println("Test Case 3: " + s3 + " and " + t3 + " -> " + prob3.isAnagram(s3, t3)); 

        // Test case 4: Longer strings
        String s4 = "aabbcc";
        String t4 = "abcabc";
        System.out.println("Test Case 4: " + s4 + " and " + t4 + " -> " + prob3.isAnagram(s4, t4)); 
        
        // Test case 5: No anagram
        String s5 = "hello";
        String t5 = "helloworld";
        System.out.println("Test Case 5: " + s5 + " and " + t5 + " -> " + prob3.isAnagram(s5, t5)); 
	}

}
