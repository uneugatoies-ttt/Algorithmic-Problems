package ict_practice.part3.impl;



// imperfect approach
/*
class Q09Solution {
    public int solution(String s) {
		int len = s.length();
        
        if (len == 1)
            return 1;
		
		int[] reslen = new int[(len / 2) + 1];
		Arrays.fill(reslen, Integer.MAX_VALUE);

		boolean notmatchflag;
		int templen;
		int rem;
		
		boolean encodingflag;
		boolean initialflag;
		boolean exceedflag;
		
		for (int i = 1; i <= len / 2; ++i) {
			rem = len % i;
			templen = len;
			int j = 0;
			int m = 0;
			
			encodingflag = false;
			initialflag = false;
			exceedflag = false;
			
			while (j < len - i - rem && (j + m) <= len - i - rem) {
				notmatchflag = false;
				for (int k = 0; k < i; ++k) {
					if (j + m + i + k >= len || j + k >= len) {
						exceedflag = true;
						break;
					}
					if (s.charAt(j + m + i + k) != s.charAt(j + k)) {
						notmatchflag = true;
						break;
					}
				}
				
				if (exceedflag) {
					break;
				}
				
				if (notmatchflag) {
					j = j + m + i;
					m = 0;
					encodingflag = false;
					initialflag = false;
					continue;
				} else {
					encodingflag = true;
					templen = templen - i;
					m = m + i;
				}
				
				if (!initialflag && encodingflag) {
					templen++;
					initialflag = true;
				}
			}
			
			reslen[i] = templen;
		}
		
		return Arrays.stream(reslen).min().orElseThrow();
    }
}
*/


/*
public class Q09 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		Q09Solution s = new Q09Solution();
		int res = s.solution(reader.readLine());
		
		System.out.println(res);
		
		
	}
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String str = reader.readLine();
		int len = str.length();
		int[] reslen = new int[(len / 2) + 1];
		Arrays.fill(reslen, Integer.MAX_VALUE);

		boolean flag;
		int templen;
		int rem;
		boolean flag2;
		boolean flag3;
		boolean flaglast;
		for (int i = 1; i <= len / 2; ++i) {
			rem = len % i;
			templen = len;
			int j = 0; int m = 0;
			flag2 = false;
			flag3 = false;
			flaglast = false;
			while (j < len - i - rem && (j + m) <= len - i - rem) {
				flag = false;
				for (int k = 0; k < i; ++k) {
					if (j + m + i + k >= len || j + k >= len) {
						flaglast = true;
						break;
					}
					if (str.charAt(j + m + i + k) != str.charAt(j + k)) {
						flag = true;
						break;
					}
				}
				
				if (flaglast) {
					break;
				}
				
				if (flag) {
					j = j + m + i;
					m = 0;
					flag2 = false;
					flag3 = false;
					continue;
				} else {
					flag2 = true;
					templen = templen - i;
					m = m + i;
				}
				
				if (!flag3 && flag2) {
					templen++;
					flag3 = true;
				}
			}
			
			reslen[i] = templen;
		}
		
		System.out.println(Arrays.stream(reslen).min().orElseThrow());
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}*/
	
