package com.jsp.cemautomationengine.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jsp.cemautomationengine.entity.WorkflowModel;

@Repository
public interface WorkflowRepository extends JpaRepository<WorkflowModel, BigInteger>{
//	getDraftWfByWfCode

	public WorkflowModel findByWfId(String WfId);
	
	public WorkflowModel findByWfCodeAndStatusFlag(String wfCode, String statusFlag);
	
	 @Query(value = "SELECT MAX(version) FROM CEM_WORKFLOW WHERE wf_code = :wfCode", 
	           nativeQuery = true)
	public Integer findMaxVersionByWfCode(@Param("wfCode") String wfCode);

	public List<WorkflowModel> findActiveWorkflowsByWfId(String wfId);
	
	public List<WorkflowModel> findByworkflowName(String workflowName);
}
