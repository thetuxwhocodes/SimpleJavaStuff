package com.girish.simple.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.girish.simple.dto.DTO;
import com.girish.simple.entity.Entity;

public class DataTransformerInstance {

	public List<DTO> doBusinessTask(List<DTO> inputDTOs) {
		
		List<Entity> entities = inputDTOs.stream().map(this::toEntity).collect(Collectors.toList());
		System.out.println("Entities after Transformation" + entities);
		
		//Business Logic goes here
		
		List<DTO> dtos = entities.stream().map(this::toDTO).collect(Collectors.toList());
		
		return dtos;
	}

	public Entity toEntity(DTO dto) {
		Entity entity = new Entity();

		entity.setField1(dto.getField1());
		entity.setField2(dto.getField2());
		entity.setField3(dto.getField3());

		return entity;

	}

	public DTO toDTO(Entity entity) {
		DTO dto = new DTO();

		dto.setField1(entity.getField1());
		dto.setField2(entity.getField2());
		dto.setField3(entity.getField3());

		return dto;

	}

	public static void main(String[] args) {

		List<DTO> inputDTOs = new ArrayList<>();
		inputDTOs.add(new DTO("ABC", 1, "AAAA"));
		inputDTOs.add(new DTO("DEF", 2, "DDDD"));
		inputDTOs.add(new DTO("GHI", 3, "GGGG"));
		inputDTOs.add(new DTO("JKL", 4, "JJJJ"));

		System.out.println("DTO before business action:" + inputDTOs);
		
		List<DTO> outputDTOs = new DataTransformerInstance().doBusinessTask(inputDTOs);
		System.out.println("After Business operation: " + outputDTOs);

	}

}





