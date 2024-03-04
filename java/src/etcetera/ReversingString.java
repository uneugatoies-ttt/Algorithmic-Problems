package etcetera;

import java.util.stream.Stream;

public class ReversingString {
	
	private static String reverse(String str) {
		if (str.isEmpty()) return str;
		return reverse(str.substring(1)) + str.charAt(0);
	}
	
	public static void main(String[] args) {
		String orig = "Hello, world!";
		
		// 1) Using StringBuilder or StringBuffer
		String reversed1 = new StringBuilder(orig).reverse().toString();
		
		// 2) Using character array
		char[] chars = orig.toCharArray();
		
		int left = 0, right = chars.length - 1;
		while (left < right) {
			char temp = chars[left];
			chars[left] = chars[right];
			chars[right] = temp;
			left++;
			right--;
		}
		String reversed2 = new String(chars);
		
		// 3) Using recursion
		String reversed3 = reverse(orig);
		
		System.out.println(reversed1);
		System.out.println(reversed2);
		System.out.println(reversed3);
	}

}
