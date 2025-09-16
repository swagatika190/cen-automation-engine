package com.jsp.cemautomationengine.dto;

import java.util.List;

import lombok.Data;

@Data
public class WorkflowDto {
	
    private String wfCode;
	
	private String workflowName;

	private String statusFlag;

	private String entitycode;

	private String uniquefield;

	private String sourceData;

	private String wfDescription;

	private String operationType;
}
