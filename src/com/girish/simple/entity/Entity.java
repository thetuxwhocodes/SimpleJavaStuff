package com.girish.simple.entity;

public class Entity {

	private String field1;
	private int field2;
	private String field3;

	public Entity() {
	}

	public Entity(String field1, int field2, String field3) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public int getField2() {
		return field2;
	}

	public void setField2(int field2) {
		this.field2 = field2;
	}

	public String getField3() {
		return field3;
	}

	public void setField3(String field3) {
		this.field3 = field3;
	}

	@Override
	public String toString() {
		return String.format("Entity: <%s, %d, %s>", field1, field2, field3);
	}
}
