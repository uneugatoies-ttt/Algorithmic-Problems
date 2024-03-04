package ict_practice.part3.binsearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q30 {
	
	// Store the given words by their length
	List<List<String>> byLen = new ArrayList<>();
	// To handle the case where ? is at the beginning;
	// store the inversed words by their length 
	List<List<String>> byLenInv = new ArrayList<>();
	
	private int lowerBound(List<String> arr, String target,int start, int end) {
		int mid;
		while (start < end) {
			mid = (start + end) / 2;
			// arr[mid] is at the same as or a latter position
			// than that of "target", lexicographically
			if (arr.get(mid).compareTo(target) >= 0)
				end = mid;
			else
				start = mid + 1;
		}
		return end;
	}
	
	private int upperBound(List<String> arr, String target,int start, int end) {
		int mid;
		while (start < end) {
			mid = (start + end) / 2;
			// arr[mid] is at a latter position
			// than that of "target", lexicographically
			if (arr.get(mid).compareTo(target) > 0)
				end = mid;
			else
				start = mid + 1;
		}
		return end;
	}
	
	// "leInd" indicates the smallest index that matches this query;
	// "riInd" indicates the largest index that matches this query + 1;
	// The difference is the number of matches.
	private int countByRange(List<String> arr, String le, String ri) {
		int leInd = lowerBound(arr, le, 0, arr.size());
		int riInd = upperBound(arr, ri, 0, arr.size());
		return riInd - leInd;
	}
	
	public int[] solution(String[] words, String[] queries) {
		List<Integer> ans = new ArrayList<>();
		
		// Greatest length of a word is 10000
		for (int i = 0; i < 10001; ++i) {
			byLen.add(new ArrayList<>());
			byLenInv.add(new ArrayList<>());
		}
		
		String temp, reversedTemp;
		for (int i = 0; i < words.length; ++i) {
			temp = words[i];
			reversedTemp = (new StringBuilder(temp)).reverse().toString();
			byLen.get(temp.length()).add(temp);
			byLenInv.get(temp.length()).add(reversedTemp);
		}
		
		for (int i = 0; i < 10001; ++i) {
			Collections.sort(byLen.get(i));
			Collections.sort(byLenInv.get(i));
		}
		
		int res;
		for (int i = 0; i < queries.length; ++i) {
			temp = queries[i];
			res = 0;
			// wildcard at the end of this word
			if (temp.charAt(0) != '?')
			{
				// replacing 
				res = 
					countByRange(
						byLen.get(temp.length()),
						temp.replaceAll("\\?", "a"),
						temp.replaceAll("\\?", "z")
					);
			}
			// wildcard at the beginning of this word
			else
			{
				temp = (new StringBuilder(temp)).reverse().toString();
				res = 
					countByRange(
						byLenInv.get(temp.length()),
						temp.replaceAll("\\?", "a"),
						temp.replaceAll("\\?", "z")
					);
			}
			ans.add(res);
		}
		
		int[] result = new int[ans.size()];
		for (int i = 0; i < ans.size(); ++i)
			result[i] = ans.get(i);
		return result;
	}
	
}
