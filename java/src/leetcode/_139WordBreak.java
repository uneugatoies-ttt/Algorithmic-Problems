package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _139WordBreak {
	public static void main(String[] args) {
		/*
		String s = "catsandog";
		String[] words = {"cats", "dog", "sand", "and", "cat"};
		List<String> wordDict = Arrays.asList(words);
		*/
		
		String s = "leetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleetleet";
		String[] words = { "leet", "code" };
		List<String> wordDict = Arrays.asList(words);
		
		_139SolutionDP2 solution = new _139SolutionDP2();
		

		
		System.out.println(solution.wordBreak(s, wordDict));
		
		
		
		
	}
}

class _139Solution {
	boolean[] dp = new boolean[301];
	
	
	public boolean wordBreak(String s, List<String> wordDict) {
		int n = s.length();
		dp[n] = true;
		for (int i = n - 1; i >= 0; --i) {
			for (int j = 1; i + j <= n; ++j) {
				if (dp[i + j] && wordDict.indexOf(s.substring(i, i + j)) != -1) {
					dp[i] = true;
					break;
				}
			}
		}
		
		return dp[0];
	}
}

class _139SolutionDP2 {
	boolean[] dp = new boolean[301];
	
	boolean wordBreak(String s, List<String> wordDict) {
		int n = s.length();
		dp[n] = true;
		
		for (int i = n - 1; i >= 0; --i) {
			dp[i] = (wordDict.indexOf(s.substring(i)) != -1 ? true : false);
			for (int j = 1; j + i <= n; ++j) {
				dp[i] = dp[j + i] && (wordDict.indexOf(s.substring(i, i + j)) != -1);
				if (dp[i]) break;
			}
		}
		
		return dp[0];
	}
}



// drastically failed attempt
/*
class _139Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
    	String t = null;
    	String tw = null;
    	
    	for (int a = 0; a < wordDict.size(); ++a) {
    		t = s;
    		boolean flagInit = false;
	    	for (int i = 0; i < wordDict.size(); ++i) {
	    		for (int j = 0; j + wordDict.get(i).length() <= t.length(); ++j)
	    			if (t.substring(j, j + wordDict.get(i).length()).equals(wordDict.get(i))) {
	    				t = t.substring(0, j) + t.substring(j + wordDict.get(i).length());
	    				flagInit = true;
	    				break;
	    			}
	    		if (flagInit) break;
	    	}
	    	if (!flagInit) continue;
	    	
	    	boolean flag = true;
	    	while (flag) {
	    		flag = false;
		    	for (int i = 0; i < wordDict.size(); ++i) {
		    		tw = wordDict.get(i);
		    		int k = 0;
		    		while (k + tw.length() <= t.length()) {
		    			if (t.substring(k, k + tw.length()).equals(tw)) {
		    				t = t.substring(0, k) + t.substring(k + tw.length());
		    			} else {
		    				k++;
		    			}
		    		}
		    	}
		    	if (t.isEmpty()) return true;
		    	for (int i = 0; i < wordDict.size(); ++i) {
		    		for (int j = 0; j + wordDict.get(i).length() <= t.length(); ++j)
		    			if (t.substring(j, j + wordDict.get(i).length()).equals(wordDict.get(i))) {
		    				flag = true;
		    				break;
		    			}
		    		if (flag) break;
		    	}
	    	}
    	}
    	
    	return false;
    }
}
*/