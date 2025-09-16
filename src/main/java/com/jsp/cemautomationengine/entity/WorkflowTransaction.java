package com.jsp.cemautomationengine.entity;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "workflow_transaction")
public class WorkflowTransaction {
	@Id
	@Column(name = "ALT_KEY")
	private Long altKey; // BIGINT maps to Long

	@Column(name = "TRANSACTION_ID")
	private String transactionId; // VARCHAR maps to String

	@Column(name = "TRANSACTION_UNIQUE_VALUE")
	private String transactionUniqueValue; // VARCHAR maps to String

	@Column(name = "WF_ID")
	private String wfId; // VARCHAR maps to String

	@Column(name = "WF_CODE")
	private String wfCode; // VARCHAR maps to String

	@Column(name = "STATUS_FLAG")
	private String statusFlag; // VARCHAR maps to String

	@Column(name = "TRANSACTION_START_DATE")
	private Date transactionStartDate; // DATE maps to Date

	@Column(name = "TRANSACTION_END_DATE")
	private Date transactionEndDate; // DATE maps to Date

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

//	public Long getAltKey() {
//		return altKey;
//	}
//
//	public void setAltKey(Long altKey) {
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
//	public String getWfCode() {
//		return wfCode;
//	}
//
//	public void setWfCode(String wfCode) {
//		this.wfCode = wfCode;
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

}

