package com.jsp.cemautomationengine.converter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.AttributeConverter;

public class UniqueFieldConverter implements AttributeConverter<List<Object>, String>{

	private final  ObjectMapper objectMapper=new ObjectMapper();
	@Override
	public String convertToDatabaseColumn(List<Object> attribute) {
		
		if (attribute == null) {
            return null;
        }
        try {
            // Convert JSON object to a String
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Error converting List<Object> to String: " + e.getMessage(), e);
        }		
	}

	@Override
	public List<Object> convertToEntityAttribute(String dbData) {
		 if (dbData == null || dbData.isEmpty()) {
	            return null;
	        }
	        try {
	            return objectMapper.readValue(dbData, List.class);
	        } catch (IOException e) {
	            throw new IllegalArgumentException("Error converting String to List<Object>: " + e.getMessage(), e);
	        }		
	}

}
