package com.jsp.cemautomationengine.converter;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.AttributeConverter;

public class MapToStringConverter implements AttributeConverter<Map<String, String>, String> {

	@Override
	public String convertToDatabaseColumn(Map<String, String> attribute) {
		ObjectMapper objectMapper = new ObjectMapper();
		String mapAsString = null;
		try {
			mapAsString = objectMapper.writeValueAsString(attribute);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println("Map as String: " + mapAsString);
		return mapAsString;
	}

	@Override
	public Map<String, String> convertToEntityAttribute(String dbData) {
		
		return null;
	}

}
