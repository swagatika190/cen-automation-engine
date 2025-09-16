package com.jsp.cemautomationengine.service;

import java.math.BigInteger;
import java.util.Date;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.jsp.cemautomationengine.context.WorkflowTransactionContext;
import com.jsp.cemautomationengine.entity.EntityModel;
import com.jsp.cemautomationengine.entity.WorkflowModel;
import com.jsp.cemautomationengine.entity.WorkflowTransaction;
import com.jsp.cemautomationengine.repository.WorkflowTransactionRepository;

public class WorkflowTriggerServiceImpl implements WorkflowTriggerService {
	@Autowired
	WorkflowTransactionRepository wftransactionrepository;
	
	@Autowired
	WorkflowTransactionServiceImpl wftransactionserviceimpl;

	@Override
	public void triggerWorkFlow(WorkflowModel workflowModel, EntityModel entityModel, String uniqueValue) {
		WorkflowTransactionContext wftranscontext = new WorkflowTransactionContext();
		wftranscontext.setEntity(entityModel);
		wftranscontext.setEventType(uniqueValue);
		wftranscontext.setExecutionEnd(entityModel.getModifiedDate());
		wftranscontext.setExecutionStart(entityModel.getCreatedDate());
		wftranscontext.setExecutionStatus(workflowModel.getStatusFlag());
		wftranscontext.setRemarks(entityModel.getRemarks());
		wftranscontext.setWorkflowModel(workflowModel);
		wftranscontext.setRemarks(null);
			
		WorkflowTransaction workflowTransaction = new WorkflowTransaction();
		workflowTransaction.setAltKey(1111L);
		workflowTransaction.setCreatedDate(new Date());
		workflowTransaction.setRemarks(null);
		workflowTransaction.setStatusFlag("QUEUE");
		workflowTransaction.setWfId(workflowModel.getWfId());
		workflowTransaction.setWfCode(workflowModel.getWfCode());
		
        wftransactionserviceimpl.processWorkflowTransactionModel(workflowTransaction);
		
		WorkflowTransactionContext workflowTransactionContext = new WorkflowTransactionContext();
		
		workflowTransactionContext.setAltKey(1111);
		workflowTransactionContext.setEventType(null);
		workflowTransactionContext.setNextNodeConfig(null);
		
		addContextToQueueAndProcess(workflowTransactionContext);
	}

	@Override
	public void addContextToQueueAndProcess(WorkflowTransactionContext context) {
		
      RabbitMqServiceImpl rabbitMqServiceImpl = new RabbitMqServiceImpl();
		
		//rabbitMqServiceImpl.sendMessage(wfTransactionContext);
	}

	
}
