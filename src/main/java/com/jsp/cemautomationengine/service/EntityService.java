package com.jsp.cemautomationengine.service;

import java.math.BigInteger;
import java.util.List;

import com.jsp.cemautomationengine.dto.AppResponseDto;
import com.jsp.cemautomationengine.dto.EntityDTO;
import com.jsp.cemautomationengine.entity.EntityModel;

public interface EntityService {
   public AppResponseDto createEntity(EntityDTO entityDTO);	

   public List<EntityModel>getAllEntity();
   
   public EntityModel getEntityByEntityCode(String entityCode);
   
   public EntityModel getEntityById(BigInteger altKey);

   
}
