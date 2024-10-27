package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitWordBySeparator {

	public static void main(String[] args) {
	List<String>	words = Arrays.asList("one.two.three","four.five","six");
	char separator = '.';
	
	List<String> list=splitWordsBySeparator(words,separator);
	for(String str:list) {
		System.out.println("Strings are "+ str +"\n");
	}
	}
	
public static List<String> splitWordsBySeparator(List<String> words,char seperator){
	List<String> result =new ArrayList<>();
	for(int i=0;i<words.size();i++) {
		String[] arr= words.get(i).split("["+seperator+"]");
		for(int j=0;j<arr.length;j++) {
			if(arr[j].length()>0) {
				result.add(arr[j]);
			}
		}
	}
	return result;
}
}
