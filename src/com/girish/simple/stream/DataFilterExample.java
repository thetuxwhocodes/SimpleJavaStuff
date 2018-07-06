package com.girish.simple.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static java.util.stream.Collectors.*;

public class DataFilterExample {

	static Map<Integer, ICF> icfById = new HashMap<>();

	static {
		icfById.put(1, new ICF(1, "ICF1", "A", "R"));
		icfById.put(2, new ICF(2, "ICF2", "B", ""));
		icfById.put(3, new ICF(3, "ICF3", "C", "R"));
		icfById.put(4, new ICF(4, "ICF4", "D", "R"));
		icfById.put(5, new ICF(5, "ICF5", "E", "R"));
		icfById.put(6, new ICF(6, "ICF6", "F", "E"));
		icfById.put(7, new ICF(7, "ICF7", "G", "R"));
		icfById.put(8, new ICF(8, "ICF8", "H", "M"));
		icfById.put(9, new ICF(9, "ICF9", "I", "R"));
		icfById.put(10, new ICF(10, "ICF10", "J", "X"));

	}

	public static void main(String[] args) {
		IC icObj = getICObj();
		Set<Integer> icFieldsSetForICObj = icObj.getData().keySet();

		// Using for loop
		List<String> codesOfICObjFor = new ArrayList<>();
		for (Map.Entry<Integer, ICF> entry : icfById.entrySet()) {
			if (icFieldsSetForICObj.contains(entry.getKey()) && entry.getValue().getType().equals("R")) {
				codesOfICObjFor.add(entry.getValue().getIcfCode());
			}

		}
		System.out.println(codesOfICObjFor);

		// Using Stream and Filters
		List<String> codesOfICObjStream = icfById.entrySet().stream()
				.filter(entry -> icFieldsSetForICObj.contains(entry.getKey()))
				.filter(entry -> entry.getValue().getType().equals("R"))
				.map(entry -> entry.getValue().getIcfCode())
				.collect(toList());
		System.out.println(codesOfICObjStream);

	}

	private static IC getICObj() {
		IC icObj = new IC(100, "IC 100");
		icObj.getData().put(1, "ABC");
		icObj.getData().put(2, "DEF");
		icObj.getData().put(3, "GHI");
		icObj.getData().put(5, "JKL");
		icObj.getData().put(6, "MNO");
		icObj.getData().put(7, "PQR");
		icObj.getData().put(8, "STU");
		return icObj;
	}

}

class IC {

	int icId;
	String icName;
	Map<Integer, String> data = new HashMap<>();

	public IC(int icId, String icName) {
		super();
		this.icId = icId;
		this.icName = icName;
	}

	public int getIcId() {
		return icId;
	}

	public void setIcId(int icId) {
		this.icId = icId;
	}

	public String getIcName() {
		return icName;
	}

	public void setIcName(String icName) {
		this.icName = icName;
	}

	public Map<Integer, String> getData() {
		return data;
	}

	public void setData(Map<Integer, String> data) {
		this.data = data;
	}
}

class ICF {
	int icfId;
	String icfName;
	String icfCode;
	String type;

	public ICF(int icfId, String icfName, String icfCode, String type) {
		super();
		this.icfId = icfId;
		this.icfName = icfName;
		this.icfCode = icfCode;
		this.type = type;
	}

	public int getIcfId() {
		return icfId;
	}

	public void setIcfId(int icfId) {
		this.icfId = icfId;
	}

	public String getIcfName() {
		return icfName;
	}

	public void setIcfName(String icfName) {
		this.icfName = icfName;
	}

	public String getIcfCode() {
		return icfCode;
	}

	public void setIcfCode(String icfCode) {
		this.icfCode = icfCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
