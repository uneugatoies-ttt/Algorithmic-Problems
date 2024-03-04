package ict_practice.part3.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q18 {
	
	public String putthingsright(String given) {
		if (given.length() == 0) return "";
		
		int m = 0;
		int i = 0;
		boolean right = true;
		do {
			if (given.charAt(i) == ')') m++;
			if (given.charAt(i) == '(') m--;
			if (m > 0) right = false;
			i++;
		} while (m != 0);
		
		String u = given.substring(0, i);
		String v = given.substring(i);
		
		if (right) {
			return u + putthingsright(v);
		} else {
			u = u.replace('(', '0');
			u = u.replace(')', '(');
			u = u.replace('0', ')');
			u = u.substring(1, u.length() - 1);
			return "(" + putthingsright(v) + ")" + u;
		}
	}
	
	public String solution(String p) {
        return putthingsright(p);
    }
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String given = reader.readLine();
		Q18 q = new Q18();
		System.out.println( q.solution(given) );
	}

}

