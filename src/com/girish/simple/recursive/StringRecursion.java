package com.girish.simple.recursive;

public class StringRecursion {

	public static void main(String[] args) {
		String str = "malayalam";
		System.out.println(reverse(str));
	}

	private static String reverse(String str) {
		
		if(str == null || str.length() <= 1) {
			return str;
		}
		
		return reverse(str.substring(str.length() -1, str.length() ) )  + reverse(str.substring(0, str.length() -1));
		
	}

}
