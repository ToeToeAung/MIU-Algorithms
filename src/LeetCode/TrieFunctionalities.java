package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TrieFunctionalities {
	public static TrieNode root;

	public static List<String> removeSubfolders(String[] folder) {
	    Arrays.sort(folder, Comparator.comparingInt(String::length));
	    root = new TrieNode();
	    List<String> result = new ArrayList<>();
	    for(String s : folder) {
	        if(insert(s,root,0)) {
	            result.add(s);
	        }
	    }
	    return result;
	}

	private static boolean insert(String key,TrieNode root,int d) {
	    if(d==key.length()) {
	        root.isEnd=true;
	        return true;
	    }
	    char c = key.charAt(d);
	    if((c=='/' && root.children[26]==null) || (c!='/' && root.children[c-'a']==null)) {
	        if(c-'a'>=0) {
	            root.children[c-'a']=new TrieNode();
	        } else {
	            root.children[26] = new TrieNode();
	        }
	    } else if(c!='/' && root.children[c-'a'].isEnd
	            && d<key.length()-1 && key.charAt(d+1)=='/') {
	        return false;
	    }
	    return insert(key,(c=='/'?root.children[26]:root.children[c-'a']),d+1);
	}
	
	public static void main(String[] args) {
		String[] folder = {"/a","/a/b/c","/a/b/d"};
		List<String> strList= new ArrayList<String>();
		strList = removeSubfolders(folder);
		for(String str :strList) {
			System.out.println("String from the list "+ str);
		}
		
	}
}
