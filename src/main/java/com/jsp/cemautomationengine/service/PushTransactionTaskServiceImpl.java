package com.jsp.cemautomationengine.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.jsp.cemautomationengine.dto.AppResponseDto;
import com.jsp.cemautomationengine.entity.EntityModel;
import com.jsp.cemautomationengine.entity.WorkflowModel;

public class PushTransactionTaskServiceImpl implements PushTransactionTaskService {

	@Autowired
	private WorkflowTriggerService workflowTriggerService;

	@Override
	public AppResponseDto initiatePushTransaction(WorkflowModel workflowModel, EntityModel entityModel, String uniqueValue) {
		//workflowTriggerService.triggerWorkFlow(workflowModel, entityModel, uniqueValue);
      return null;
	}

	@Override
	public AppResponseDto processManualTransactionData(WorkflowModel workflowModel, EntityModel entityModel,
			Map<String, Object> manualPushDetails) {
		//initiatePushTransaction(workflowModel, entityModel, (String)manualPushDetails.get("uniqueValue"));
        return null;
	}
}