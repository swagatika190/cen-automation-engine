package com.jsp.cemautomationengine.service;

import com.jsp.cemautomationengine.context.NodeExecutionContext;
import com.jsp.cemautomationengine.context.WorkflowTransactionContext;
import com.jsp.cemautomationengine.entity.WorkflowTransaction;

public interface WorkflowTransactionService {

    public void execute(WorkflowTransactionContext workflowtransactioncontext);
	
	
	public void insertWorkflowTransactionAudit(WorkflowTransactionContext wftransactiionContext,NodeExecutionContext NodeExecutionContext);
	
	
	void processWorkflowTransactionModel(WorkflowTransaction model);

}
