package com.jsp.cemautomationengine.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntityDTO {

	private String entityCode;
	
	private String entityName;
	
	private String entityDescription;
	
	private List<Object> uniqueField;
	
	private List<Object> statusFieldsValues;
	
	private String remarks;
	
	private String userName;
}
