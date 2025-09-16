package com.jsp.cemautomationengine.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jsp.cemautomationengine.entity.EntityModel;


public interface EntityRepository extends JpaRepository<EntityModel, BigInteger>{

	public EntityModel findByEntityCode(String entityCode);

}
