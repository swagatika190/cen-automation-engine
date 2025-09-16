package com.jsp.cemautomationengine.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.cemautomationengine.entity.NodeDetailsModel;

@Repository
public interface NodeRepository extends JpaRepository<NodeDetailsModel, BigInteger>{
   
	public List<NodeDetailsModel> findByWfId(String wfId);
}
