package com.jsp.cemautomationengine.service;

import java.util.Map;

import com.jsp.cemautomationengine.dto.AppResponseDto;
import com.jsp.cemautomationengine.entity.EntityModel;
import com.jsp.cemautomationengine.entity.WorkflowModel;

public interface PushTransactionTaskService {

public AppResponseDto initiatePushTransaction(WorkflowModel workflowModel, EntityModel entityModel, String uniqueValue);

public AppResponseDto processManualTransactionData(WorkflowModel workflowModel, EntityModel entityModel,
			Map<String, Object> manualPushDetails);

}
