package com.jsp.cemautomationengine.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.cemautomationengine.constant.MappingConstants;
import com.jsp.cemautomationengine.dto.AppResponseDto;
import com.jsp.cemautomationengine.dto.WorkflowDto;
import com.jsp.cemautomationengine.service.WorkflowService;
import com.rabbitmq.client.observation.micrometer.RabbitMqObservationDocumentation;

@RestController
public class WorkflowController {
	@Autowired
	private WorkflowService workflowService;
	
	
	@PostMapping(value = MappingConstants.UPDATE_WORK_FLOW)
	public@ResponseBody void updateWorkflow(@RequestBody  WorkflowDto workflowDTO) {
		workflowService.processWorkflow(workflowDTO);
	}
	
	@PutMapping(value = MappingConstants.UPDATE_STATUS)
	public AppResponseDto updateStatus(@RequestBody Map<String, Object> statusMap) {
		return workflowService.processUpdateStatus(statusMap);
	}
}
