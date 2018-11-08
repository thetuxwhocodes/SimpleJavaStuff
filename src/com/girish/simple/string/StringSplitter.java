package com.girish.simple.string;

import java.util.Arrays;

public class StringSplitter {

	public static void main(String[] args) {
		String str = "banks|123456|11";
		System.out.println(str.split("\\|").length);
		Arrays.stream(str.split("\\|")).forEach(System.out::println);

	}

}
