package com.jsp.cemautomationengine.service;

import com.jsp.cemautomationengine.context.WorkflowTransactionContext;
import com.jsp.cemautomationengine.entity.EntityModel;
import com.jsp.cemautomationengine.entity.WorkflowModel;

public interface WorkflowTriggerService {

	void triggerWorkFlow(WorkflowModel workflowModel, EntityModel entityModel, String uniqueValue);

	void addContextToQueueAndProcess(WorkflowTransactionContext context);

}
