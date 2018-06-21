package com.girish.simple.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CricketMapper {

	public static void main(String[] args) {
		
		List<Cricketer> cricketers = new ArrayList<>();
		cricketers.add(new Cricketer("Virat Kohli", "India", true));
		cricketers.add(new Cricketer("Nathan Lyon", "Australia", false));
		cricketers.add(new Cricketer("Eoin Morgan", "England", true));
		cricketers.add(new Cricketer("Joe Root", "England", true));
		cricketers.add(new Cricketer("Rashid Khan", "Afghanistan", false));
		cricketers.add(new Cricketer("Hashim Amla", "South Africa", false));
		cricketers.add(new Cricketer("Faf du Plessis", "South Africa", true));
		cricketers.add(new Cricketer("Kane Williamson", "New Zealand", true));
		cricketers.add(new Cricketer("Neil Wagner", "New Zealand", false));
		cricketers.stream().forEach(System.out::println);
		
		cricketers.sort((c1, c2) -> c1.getName().compareTo(c2.getName()));
		System.out.println("Sorted by Name: " + cricketers);
		
		cricketers.sort((c1, c2) -> c1.getCountry().compareTo(c2.getCountry()));
		System.out.println("Sorted by Country: " + cricketers);
		
		List<String> namesOnly = cricketers.stream().map(c->c.getName()).collect(Collectors.toList());
		System.out.println("namesOnly = " + namesOnly);

		List<String> captains = cricketers.stream().filter(c -> c.isCaptain()).map(c->c.getName()).collect(Collectors.toList());
		System.out.println("captains = " + captains);

		Map<String, List<Cricketer>> countryWiseMapping = cricketers.stream().collect(Collectors.groupingBy(c -> c.getCountry()));
		System.out.println("countryWiseMapping = " + countryWiseMapping);
		
		Map<String, List<String>> countryWiseMappingNamesOnly =  cricketers.stream().collect(Collectors.groupingBy(c -> c.getCountry(), Collectors.mapping(Cricketer::getName, Collectors.toList())));
		System.out.println("countryWiseMappingNamesOnly = " + countryWiseMappingNamesOnly);
		
		
	}

}

class Cricketer {

	private String name;
	private String country;
	boolean isCaptain;

	public Cricketer() {
	}

	public Cricketer(String name, String country, boolean isCaptain) {
		super();
		this.name = name;
		this.country = country;
		this.isCaptain = isCaptain;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	

	public boolean isCaptain() {
		return isCaptain;
	}

	public void setCaptain(boolean isCaptain) {
		this.isCaptain = isCaptain;
	}

	@Override
	public String toString() {
		return String.format("%s from %s", name, country);
	}
}
