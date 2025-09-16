package com.jsp.cemautomationengine.context;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jsp.cemautomationengine.config.NodeConfig;
import com.jsp.cemautomationengine.entity.EntityModel;
import com.jsp.cemautomationengine.entity.WorkflowModel;
import com.jsp.cemautomationengine.entity.WorkflowTransactionLogModel;
import com.jsp.cemautomationengine.result.NodeExecutionResult;

public class NodeExecutionContext  implements Cloneable{
	
	private Date executionStart;
	private Date executionEnd;
	private String executionStatus;
	private String nodeId;
	private NodeConfig prevExecutedNodeConfig;
	private NodeConfig currentNodeConfig;
	private List<NodeConfig> nextExecutionNodeConfigs = new ArrayList<>();
	private WorkflowModel workFlowModel;
	private WorkflowTransactionLogModel workflowTransactionModel;
	private NodeExecutionResult nodeExecutionResult;
	private Map<String, Object> transactionDataMap = new HashMap<>();
	private EntityModel entityModel;
	private Map<String, String> processVariables = new HashMap<>();
	private Map<String, Object> cronPickupMetaDataMap = new HashMap<>();
	private Date timerNodeTriggerDate; // Corrected spelling from Tigger to Trigger
	private String nodeType; // Changed to camelCase
    private Long phoneNumber; // Changed to camelCase
    private String message; // Changed to camelCase

	public NodeExecutionContext(WorkflowTransactionContext context) {
		this.workflowTransactionModel = context.getWorkflowTransactionLogModel();
	}

	// Getters and Setters
	public Date getExecutionStart() {
		return executionStart;
	}

	public void setExecutionStart(Date executionStart) {
		this.executionStart = executionStart;
	}

	public Date getExecutionEnd() {
		return executionEnd;
	}

	public void setExecutionEnd(Date executionEnd) {
		this.executionEnd = executionEnd;
	}

	public String getExecutionStatus() {
		return executionStatus;
	}

	public void setExecutionStatus(String executionStatus) {
		this.executionStatus = executionStatus;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public NodeConfig getPrevExecutedNodeConfig() {
		return prevExecutedNodeConfig;
	}

	public void setPrevExecutedNodeConfig(NodeConfig prevExecutedNodeConfig) {
		this.prevExecutedNodeConfig = prevExecutedNodeConfig;
	}

	public NodeConfig getCurrentNodeConfig() {
		return currentNodeConfig;
	}

	public void setCurrentNodeConfig(NodeConfig currentNodeConfig) {
		this.currentNodeConfig = currentNodeConfig;
	}

	public List<NodeConfig> getNextExecutionNodeConfigs() {
		return nextExecutionNodeConfigs;
	}

	public void setNextExecutionNodeConfigs(List<NodeConfig> nextExecutionNodeConfigs) {
		this.nextExecutionNodeConfigs = nextExecutionNodeConfigs;
	}

	public WorkflowModel getWorkflowModel() {
		return workFlowModel;
	}

	public void setWorkflowModel(WorkflowModel workflowModel) {
		this.workFlowModel = workflowModel;
	}

	public WorkflowTransactionLogModel getWorkflowTransactionModel() {
		return workflowTransactionModel;
	}

	public void setWorkflowTransactionModel(WorkflowTransactionLogModel workflowTransactionModel) {
		this.workflowTransactionModel = workflowTransactionModel;
	}

	public NodeExecutionResult getNodeExecutionResult() {
		return nodeExecutionResult;
	}

	public void setNodeExecutionResult(NodeExecutionResult nodeExecutionResult) {
		this.nodeExecutionResult = nodeExecutionResult;
	}

	public Map<String, Object> getTransactionDataMap() {
		return transactionDataMap;
	}

	public void setTransactionDataMap(Map<String, Object> transactionDataMap) {
		this.transactionDataMap = transactionDataMap;
	}

	public EntityModel getEntityModel() {
		return entityModel;
	}

	public void setEntityModel(EntityModel entityModel) {
		this.entityModel = entityModel;
	}

	public Map<String, String> getProcessVariables() {
		return processVariables;
	}

	public void setProcessVariables(Map<String, String> processVariables) {
		this.processVariables = processVariables;
	}

	public Map<String, Object> getCronPickupMetaDataMap() {
		return cronPickupMetaDataMap;
	}

	public void setCronPickupMetaDataMap(Map<String, Object> cronPickupMetaDataMap) {
		this.cronPickupMetaDataMap = cronPickupMetaDataMap;
	}

	public Date getTimerNodeTriggerDate() {
		return timerNodeTriggerDate;
	}

	public void setTimerNodeTriggerDate(Date timerNodeTriggerDate) {
		this.timerNodeTriggerDate = timerNodeTriggerDate;
	}

	public String getNodeType() {
		return nodeType;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

	@Override
	public NodeExecutionContext clone() {
		try {
			NodeExecutionContext cloned = (NodeExecutionContext) super.clone();

			// Deep cloning mutable fields
			cloned.executionStart = this.executionStart != null ? (Date) this.executionStart.clone() : null;
			cloned.executionEnd = this.executionEnd != null ? (Date) this.executionEnd.clone() : null;

			cloned.transactionDataMap = this.transactionDataMap != null ? new HashMap<>(this.transactionDataMap) : null;
			cloned.processVariables = this.processVariables != null ? new HashMap<>(this.processVariables) : null;
			cloned.cronPickupMetaDataMap = this.cronPickupMetaDataMap != null
					? new HashMap<>(this.cronPickupMetaDataMap)
					: null;

			cloned.timerNodeTriggerDate = this.timerNodeTriggerDate != null ? (Date) this.timerNodeTriggerDate.clone()
					: null;

			cloned.prevExecutedNodeConfig = this.prevExecutedNodeConfig != null ? this.prevExecutedNodeConfig.clone()
					: null;
			cloned.currentNodeConfig = this.currentNodeConfig != null ? this.currentNodeConfig.clone() : null;

			if (this.nextExecutionNodeConfigs != null) {
				cloned.nextExecutionNodeConfigs = new ArrayList<>();
				for (NodeConfig nodeConfig : this.nextExecutionNodeConfigs) {
					cloned.nextExecutionNodeConfigs.add(nodeConfig.clone());
				}
			}

			// Shallow copy for non-mutable fields
			cloned.workFlowModel = this.workFlowModel; // Assuming it's immutable or doesn't need deep cloning
			cloned.workflowTransactionModel = this.workflowTransactionModel; // Assuming it's immutable or doesn't need
																				// deep cloning
			cloned.nodeExecutionResult = this.nodeExecutionResult; // Assuming it's immutable or doesn't need deep
																	// cloning
			cloned.entityModel = this.entityModel; // Assuming it's immutable or doesn't need deep cloning

			return cloned;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}
}
