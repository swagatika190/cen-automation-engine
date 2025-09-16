package com.jsp.cemautomationengine.entity;

import java.math.BigInteger;
import java.util.Date;

import com.jsp.cemautomationengine.context.NodeExecutionContext;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "workflow_transaction_log")
public class WorkflowTransactionLogModel implements Cloneable{
	@Id
    @Column(name = "ALT_KEY")
	private BigInteger altKey; // BIGINT maps to BigInteger

	@Column(name = "TRANSACTION_ID")
	private String transactionId; // VARCHAR maps to String

	@Column(name = "TRANSACTION_UNIQUE_VALUE")
	private String transactionUniqueValue; // VARCHAR maps to String

	@Column(name = "WF_ID")
	private String wfId; // VARCHAR maps to String

	@Column(name = "CURRENT_NODE_ID")
	private String currentNodeId; // VARCHAR maps to String

	@Column(name = "CURRENT_NODE_TYPE")
	private String currentNodeType; // VARCHAR maps to String

	@Column(name = "STATUS_FLAG")
	private String statusFlag; // VARCHAR maps to String

	@Column(name = "EXECUTION_SIGNAL")
	private String executionSignal; // VARCHAR maps to String

	@Column(name = "CURRENT_THREAD")
	private String currentThread; // VARCHAR maps to String

	@Column(name = "REMARKS")
	private String remarks; // VARCHAR maps to String

	@Column(name = "CREATED_BY")
	private String createdBy; // VARCHAR maps to String

	@Column(name = "CREATED_DATE")
	private Date createdDate; // DATE maps to Date

	@Column(name = "MODIFIED_BY")
	private String modifiedBy; // VARCHAR maps to String

	@Column(name = "MODIFIED_DATE")
	private Date modifiedDate; // DATE maps to Date

	@Column(name = "PREVIOUS_NODE_ID")
	private String previousNodeId; // VARCHAR maps to String

	@Column(name = "TRIGGER_DATE")
	private Date triggerDate; // DATE maps to Date

	@Column(name = "TRANSACTION_START_DATE")
	private Date transactionStartDate; // DATE maps to Date

	@Column(name = "TRANSACTION_END_DATE")
	private Date transactionEndDate; // DATE maps to Date

//	public BigInteger getAltKey() {
//		return altKey;
//	}
//
//	public void setAltKey(BigInteger altKey) {
//		this.altKey = altKey;
//	}
//
//	public String getTransactionId() {
//		return transactionId;
//	}
//
//	public void setTransactionId(String transactionId) {
//		this.transactionId = transactionId;
//	}
//
//	public String getTransactionUniqueValue() {
//		return transactionUniqueValue;
//	}
//
//	public void setTransactionUniqueValue(String transactionUniqueValue) {
//		this.transactionUniqueValue = transactionUniqueValue;
//	}
//
//	public String getWfId() {
//		return wfId;
//	}
//
//	public void setWfId(String wfId) {
//		this.wfId = wfId;
//	}
//
//	public String getCurrentNodeId() {
//		return currentNodeId;
//	}
//
//	public void setCurrentNodeId(String currentNodeId) {
//		this.currentNodeId = currentNodeId;
//	}
//
//	public String getCurrentNodeType() {
//		return currentNodeType;
//	}
//
//	public void setCurrentNodeType(String currentNodeType) {
//		this.currentNodeType = currentNodeType;
//	}
//
//	public String getStatusFlag() {
//		return statusFlag;
//	}
//
//	public void setStatusFlag(String statusFlag) {
//		this.statusFlag = statusFlag;
//	}
//
//	public String getExecutionSignal() {
//		return executionSignal;
//	}
//
//	public void setExecutionSignal(String executionSignal) {
//		this.executionSignal = executionSignal;
//	}
//
//	public String getCurrentThread() {
//		return currentThread;
//	}
//
//	public void setCurrentThread(String currentThread) {
//		this.currentThread = currentThread;
//	}
//
//	public String getRemarks() {
//		return remarks;
//	}
//
//	public void setRemarks(String remarks) {
//		this.remarks = remarks;
//	}
//
//	public String getCreatedBy() {
//		return createdBy;
//	}
//
//	public void setCreatedBy(String createdBy) {
//		this.createdBy = createdBy;
//	}
//
//	public Date getCreatedDate() {
//		return createdDate;
//	}
//
//	public void setCreatedDate(Date createdDate) {
//		this.createdDate = createdDate;
//	}
//
//	public String getModifiedBy() {
//		return modifiedBy;
//	}
//
//	public void setModifiedBy(String modifiedBy) {
//		this.modifiedBy = modifiedBy;
//	}
//
//	public Date getModifiedDate() {
//		return modifiedDate;
//	}
//
//	public void setModifiedDate(Date modifiedDate) {
//		this.modifiedDate = modifiedDate;
//	}
//
//	public String getPreviousNodeId() {
//		return previousNodeId;
//	}
//
//	public void setPreviousNodeId(String previousNodeId) {
//		this.previousNodeId = previousNodeId;
//	}
//	public Date getTriggerDate() {
//		return triggerDate;
//	}
//
//	public void setTriggerDate(Date triggerDate) {
//		this.triggerDate = triggerDate;
//	}
//
//	public Date getTransactionStartDate() {
//		return transactionStartDate;
//	}
//
//	public void setTransactionStartDate(Date transactionStartDate) {
//		this.transactionStartDate = transactionStartDate;
//	}
//
//	public Date getTransactionEndDate() {
//		return transactionEndDate;
//	}
//
//	public void setTransactionEndDate(Date transactionEndDate) {
//		this.transactionEndDate = transactionEndDate;
//	}
//
	@Override
	public WorkflowTransactionLogModel clone() {
		try {
			return (WorkflowTransactionLogModel) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	
}

