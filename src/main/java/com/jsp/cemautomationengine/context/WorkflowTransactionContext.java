package com.jsp.cemautomationengine.context;

import java.math.BigInteger;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.jsp.cemautomationengine.config.NodeConfig;
import com.jsp.cemautomationengine.entity.EntityModel;
//import com.jsp.cemautomationengine.entity.NodeDetailsModel;
import com.jsp.cemautomationengine.entity.WorkflowModel;
import com.jsp.cemautomationengine.entity.WorkflowTransaction;
import com.jsp.cemautomationengine.entity.WorkflowTransactionLogModel;

public class WorkflowTransactionContext implements Cloneable {

	public static final String TX_STATUS_IN_PROGRESS = "IN_PROGRESS";
	private WorkflowModel workFlowModel;
	private EntityModel entity;
	private Date executionStart;
	private Date executionEnd;
	private String executionStatus;
	private String remarks;
	private long AltKey;
	private BigInteger workflowTransactionAltKey;
	private WorkflowTransactionLogModel workflowTransactionLogModel;
	private NodeConfig nextNodeConfig;
	private String eventType;
	private String NodeType;
	private Map<String, NodeExecutionContext> currentNodeExecutionContextMap = new ConcurrentHashMap<>();
	private WorkflowTransaction workflowtransaction;

	public NodeExecutionContext getCurrentNodeExecutionContext(String nodeId) {
        return this.currentNodeExecutionContextMap.get(nodeId);
    }//new one
	
	public WorkflowTransaction getWorkflowtransaction() {
		return workflowtransaction;
	}

	public void setWorkflowtransaction(WorkflowTransaction workflowtransaction) {
		this.workflowtransaction = workflowtransaction;
	}

	public WorkflowModel getWorkflowModel() {
		return this.workFlowModel;
	}

	public void setWorkflowModel(WorkflowModel workflowModel) {
		this.workFlowModel = workflowModel;
	}

	public EntityModel getEntity() {
		return entity;
	}

	public void setEntity(EntityModel entity) {
		this.entity = entity;
	}

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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public long getAltKey() {
		return AltKey;
	}
	public void setAltKey(long altKey) {
		AltKey = altKey;
	}
	
	public BigInteger getWorkflowTransactionAltKey() {
		return workflowTransactionAltKey;
	}

	public void setWorkflowTransactionAltKey(BigInteger workflowTransactionAltKey) {
		this.workflowTransactionAltKey = workflowTransactionAltKey;
	}

	public WorkflowTransactionLogModel getWorkflowTransactionLogModel() {
		return workflowTransactionLogModel;
	}

	public void setWorkflowTransactionLogModel(WorkflowTransactionLogModel workflowTransactionLogModel) {
		this.workflowTransactionLogModel = workflowTransactionLogModel;
	}


	public NodeConfig getNextNodeConfig() {
		return nextNodeConfig;
	}

	public void setNextNodeConfig(NodeConfig nextNodeConfig) {
		this.nextNodeConfig = nextNodeConfig;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getNodeType() {
		return NodeType;
	}
	
	public void setNodeType(String nodeType) {
		NodeType = nodeType;
	}
	
	public Map<String, NodeExecutionContext> getCurrentNodeExecutionContextMap() {
		return currentNodeExecutionContextMap;
	}

	public void setCurrentNodeExecutionContextMap(Map<String, NodeExecutionContext> currentNodeExecutionContextMap) {
		this.currentNodeExecutionContextMap = currentNodeExecutionContextMap;
	}

	
	public static String getTxStatusInProgress() {
		return TX_STATUS_IN_PROGRESS;
	}
	
	@Override
	public WorkflowTransactionContext clone() {
		try {
	WorkflowTransactionContext cloned = (WorkflowTransactionContext) super.clone();
			cloned.executionStart = this.executionStart != null ? (Date) this.executionStart.clone() : null;
			cloned.executionEnd = this.executionEnd != null ? (Date) this.executionEnd.clone() : null;

			if (this.workflowTransactionLogModel != null) {
				cloned.workflowTransactionLogModel = this.workflowTransactionLogModel.clone();
			}
			cloned.nextNodeConfig = this.nextNodeConfig; // Assuming this is immutable or not required to clone
			cloned.currentNodeExecutionContextMap = new ConcurrentHashMap<>(this.currentNodeExecutionContextMap);

			return cloned;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public String toString() {
		return "WorkflowTransactionContext [workFlowModel=" + workFlowModel + ", entity=" + entity + ", executionStart="
				+ executionStart + ", executionEnd=" + executionEnd + ", executionStatus=" + executionStatus
				+ ", remarks=" + remarks + ", workflowTransactionAltKey=" + workflowTransactionAltKey
				+ ", workflowTransactionLogModel=" + workflowTransactionLogModel + ", nextNodeConfig=" + nextNodeConfig
				+ ", eventType=" + eventType + ", NodeType=" + NodeType + ", currentNodeExecutionContextMap="
				+ currentNodeExecutionContextMap + ", workflowtransaction=" + workflowtransaction + "]";
	}
	
//	public void setNodeExecutionContext(NodeExecutionContext nodeExecutionContext) {
//		if (nodeExecutionContext == null) {
//			throw new IllegalArgumentException("NodeExecutionContext cannot be null.");
//		}
//		// Store in the map with nodeId as key and nodeExecutionContext as value
//		currentNodeExecutionContextMap.put(nodeExecutionContext.getNodeId(), nodeExecutionContext);
//
//		System.out.println("NodeExecutionContext set for Node ID: " + nodeExecutionContext.getNodeId());
//	}

	/**
	 * Retrieves the execution context by Node ID.
	 */
}
