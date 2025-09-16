package com.jsp.cemautomationengine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.cemautomationengine.entity.WorkflowTransaction;

@Repository
public interface WorkflowTransactionRepository extends JpaRepository<WorkflowTransaction, Long>{

}
