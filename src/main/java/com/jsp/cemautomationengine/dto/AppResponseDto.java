package com.jsp.cemautomationengine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppResponseDto {
	
    private String status;
	
	private String statusCode;
	
	private Object data;
	
	private String error;
	

}
