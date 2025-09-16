package com.jsp.cemautomationengine.service;

import java.util.Map;

import com.jsp.cemautomationengine.dto.AppResponseDto;
import com.jsp.cemautomationengine.dto.WorkflowDto;
import com.jsp.cemautomationengine.entity.WorkflowModel;

public interface WorkflowService {
	
  public void processWorkflow(WorkflowDto workflowDTO);
  
  public WorkflowModel getDraftByWfCode(String WfCode);
	
  public AppResponseDto processUpdateStatus(Map<String,Object> statusMap);
}
