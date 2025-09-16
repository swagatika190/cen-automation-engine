package com.jsp.cemautomationengine.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.jsp.cemautomationengine.config.NodeConfig;
import com.jsp.cemautomationengine.context.NodeExecutionContext;
import com.jsp.cemautomationengine.context.WorkflowTransactionContext;
import com.jsp.cemautomationengine.entity.WorkflowModel;
import com.jsp.cemautomationengine.entity.WorkflowTransaction;
import com.jsp.cemautomationengine.entity.WorkflowTransactionLogModel;
import com.jsp.cemautomationengine.repository.WorkflowTransactionLogRepository;
import com.jsp.cemautomationengine.repository.WorkflowTransactionRepository;
import com.jsp.cemautomationengine.result.NodeExecutionResult;

public class WorkflowTransactionServiceImpl implements WorkflowTransactionService{
    
	@Autowired
    WorkflowTransactionLogRepository wfTransactionLogRepo;
    
	@Autowired
	WorkflowTransactionRepository wftransactionrepo;
	
	
	@Autowired
	DataManagerService dataManagerService;
	
	@Autowired
    private NodeImplementationRegister nodeImplementationRegister;
	
	@Override
	public void processWorkflowTransactionModel(WorkflowTransaction model) {
		wftransactionrepo.save(model);	
		
	}

	@Override
	public void execute(WorkflowTransactionContext workflowtransactioncontext) {
	    
	    // Get the start node configurations from the workflow model
	    List<NodeConfig> startNodeConfigs =workflowtransactioncontext.getWorkflowModel().getStartNodeConfig();
	    
	    // Loop through the start node configurations and begin processing
	    for (NodeConfig startNodeConfig : startNodeConfigs) {
	    	
	        //  process the start node
	        System.out.println("Processing start node: " + startNodeConfig);
	        // Set the next node configuration in the context (example)
	       // workflowtransactioncontext.setNextNodeConfig(startNodeConfig);
	        NodeExecutionContext nodeExecutionContext=createNodeExecutionContext(workflowtransactioncontext, startNodeConfig, startNodeConfig.getNodeId());
	        
	        workflowtransactioncontext.getCurrentNodeExecutionContextMap().put(startNodeConfig.getNodeId(),
					nodeExecutionContext); 
	      boolean executeNode = executeNode(workflowtransactioncontext, nodeExecutionContext);
	        if(executeNode) {
	        executeNextNode(workflowtransactioncontext, nodeExecutionContext);
	        }
	    }
	} 
	
	public void executeNextNode(WorkflowTransactionContext workflowTransactionContext,
			NodeExecutionContext nodeExecutionContext) {
		List<NodeConfig> outgoingNodes = nodeExecutionContext.getCurrentNodeConfig().getOutgoingNodes();
		for (NodeConfig nodeConfig : outgoingNodes) {
			NodeExecutionContext nodeExecutionContext2 = createNodeExecutionContext(workflowTransactionContext,
					nodeConfig, nodeConfig.getNodeId());
			workflowTransactionContext.getCurrentNodeExecutionContextMap().put(nodeConfig.getNodeId(),
					nodeExecutionContext2);
			boolean executeNode = executeNode(workflowTransactionContext, nodeExecutionContext2);
			if (executeNode) {
				executeNextNode(workflowTransactionContext, nodeExecutionContext2);
			} else {
				break;
			}
		}
	}
	

	public boolean executeNode(WorkflowTransactionContext context, NodeExecutionContext nodeExecutionContext) {
		
	            String nodeType = nodeExecutionContext.getCurrentNodeConfig().getNodeType();
	            NodeExecutionService nodeExecutionService = nodeImplementationRegister.getNodeExecutionService(nodeType);
	            context.setExecutionStatus("IN_PROGRESS");
	    // Handle the execution result as needed
	     
	            insertWorkflowTransactionAudit(context, nodeExecutionContext);
	      
	            if( nodeExecutionService !=null) {
	            	NodeExecutionResult execute = nodeExecutionService.execute(nodeExecutionContext);
	            	return execute.isExecutionResult();
	            }
	            return false;
	}

	
	
	public NodeExecutionContext createNodeExecutionContext(WorkflowTransactionContext workflowTransactionContext, NodeConfig nodeConfig, String nodeId) {
		
        NodeExecutionContext nodeExecutionContext = new NodeExecutionContext(workflowTransactionContext);

        nodeExecutionContext.setNodeId(nodeId);
        nodeExecutionContext.setCurrentNodeConfig(nodeConfig);
        nodeExecutionContext.setExecutionStart(new Date());
        nodeExecutionContext.setWorkflowModel(workflowTransactionContext.getWorkflowModel());
        nodeExecutionContext.setEntityModel(workflowTransactionContext.getEntity());
        nodeExecutionContext.setWorkflowTransactionModel(workflowTransactionContext.getWorkflowTransactionLogModel());
        nodeExecutionContext.setExecutionStatus(WorkflowTransactionContext.TX_STATUS_IN_PROGRESS);

        if (!nodeConfig.isStartNode()) {
            NodeConfig previousNodeConfig = workflowTransactionContext.getCurrentNodeExecutionContext(nodeId).getCurrentNodeConfig();
            nodeExecutionContext.setPrevExecutedNodeConfig(previousNodeConfig);
        }
        
        Map<String, Object> transactionData = dataManagerService.getSingleTransactionData(
                workflowTransactionContext.getEntity().getEntityName(),
                "*",
                workflowTransactionContext.getWorkflowModel().getUniquefield(),
                workflowTransactionContext.getWorkflowtransaction().getTransactionUniqueValue());
        
        nodeExecutionContext.setTransactionDataMap(transactionData);
       // workflowTransactionContext.setNodeExecutionContext(nodeExecutionContext);
        //nodeconfig.gets
        return nodeExecutionContext;
    }


	@Override
	public void insertWorkflowTransactionAudit(WorkflowTransactionContext wftransactiionContext,
			NodeExecutionContext nodeExecutionContext) {
			
			WorkflowTransactionLogModel transactionLogModel = new WorkflowTransactionLogModel();
			transactionLogModel.setTransactionId(wftransactiionContext.getWorkflowtransaction().getTransactionId());
			transactionLogModel.setTransactionUniqueValue(wftransactiionContext.getWorkflowtransaction().getTransactionUniqueValue());
			transactionLogModel.setWfId(wftransactiionContext.getWorkflowModel().getWfId());
			transactionLogModel.setCurrentNodeId(nodeExecutionContext.getCurrentNodeConfig().getNodeId());
			transactionLogModel.setCurrentNodeType(wftransactiionContext.getNodeType());
			transactionLogModel.setStatusFlag("IN_PROGRESS");
			//transactionLogModel.setExecutionSignal(null);
			//transactionLogModel.setStatusFlag("Execution");
			//transactionLogModel.setRemarks(null);
			//transactionLogModel.setCurrentThread(null);
			//transactionLogModel.setCurrentNodeId("currentnode");
		    //transactionLogModel.setCurrentThread(Thread.currentThread().getName());
		   // transactionLogModel.setCurrentNodeId(nodeExecutionContext.getNodeId());
		    transactionLogModel.setCreatedDate(wftransactiionContext.getExecutionStart());
		   // transactionLogModel.setCreatedBy(null);
		    //transactionLogModel.setModifiedBy(null);
		    //transactionLogModel.setModifiedDate(null);
		    transactionLogModel.setPreviousNodeId(nodeExecutionContext.getPrevExecutedNodeConfig().getNodeId());
		    //transactionLogModel.setTriggerDate(null);
		    transactionLogModel.setTransactionStartDate(wftransactiionContext.getExecutionStart());
		    transactionLogModel.setTransactionEndDate(wftransactiionContext.getExecutionEnd());
			
			wfTransactionLogRepo.save(transactionLogModel);	
		
	}

}
