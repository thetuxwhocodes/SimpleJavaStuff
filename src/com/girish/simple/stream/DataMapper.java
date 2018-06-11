package com.girish.simple.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataMapper {

	public static void main(String[] args) {

		List<Entity> entities = new ArrayList<>();
		entities.add(new Entity("ABC", 1, "AAAA"));
		entities.add(new Entity("DEF", 2, "DDDD"));
		entities.add(new Entity("GHI", 3, "GGGG"));
		entities.add(new Entity("JKL", 4, "JJJJ"));
		
		System.out.println("Entities before transformation:" + entities);
		
		List<DTO> cdtos = entities.stream().map(entity -> new DTO(entity.getField1(), entity.getField2(), entity.getField3())).collect(Collectors.toList());
		System.out.println("DTOs after transformation (Constructor):" + cdtos);
		
		List<DTO> mdtos = entities.stream().map(entity -> Mapper.entityToDTOMapper(entity)).collect(Collectors.toList());
		System.out.println("DTOs after transformation (Mapper):" + mdtos);
		
		
	}
}

class Mapper{
	
	public static DTO entityToDTOMapper(Entity entity) {
		DTO dto = new DTO();
		
		dto.setField1(entity.getField1());
		dto.setField2(entity.getField2());
		dto.setField3(entity.getField3());
		
		return dto;
		
	}
}

class Entity {

	private String field1;
	private int field2;
	private String field3;

	public Entity() {}

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

class DTO {

	private String field1;
	private int field2;
	private String field3;
	
	public DTO() {}


	public DTO(String field1, int field2, String field3) {
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
		return String.format("DTO: <%s, %d, %s>", field1, field2, field3);
	}

}
