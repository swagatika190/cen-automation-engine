package com.jsp.cemautomationengine.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.cemautomationengine.entity.WorkflowTransactionLogModel;

@Repository
public interface WorkflowTransactionLogRepository extends JpaRepository<WorkflowTransactionLogModel,BigInteger>{

}
