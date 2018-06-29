package com.girish.simple.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.girish.simple.dto.DTO;
import com.girish.simple.entity.Entity;

public class DataTransformerStatic {

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
