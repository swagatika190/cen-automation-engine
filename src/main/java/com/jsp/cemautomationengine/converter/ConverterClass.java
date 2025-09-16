package com.jsp.cemautomationengine.converter;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.AttributeConverter;

public class ConverterClass implements AttributeConverter<List<String>, String> {

	@Override
	public String convertToDatabaseColumn(List<String> attribute) {
		return attribute !=null?String.join(",", attribute):null;
	}

	@Override
	public List<String> convertToEntityAttribute(String dbData) {
		return dbData !=null?Arrays.asList(dbData.split(",")):null;
	}

}
