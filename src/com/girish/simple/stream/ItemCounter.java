package com.girish.simple.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ItemCounter {

	public static void main(String[] args) {
		List<String> strings = List.of("A", "B", "A", "C", "A", "D", "E", "D", "E", "B", "C" );
		
		Map<String, Long> countMap = strings.stream().collect(Collectors.toMap(Function.identity(), string -> 1L, (oldCount, newCount) -> oldCount + newCount));
		
		System.out.println(countMap);
		
		

	}

}
