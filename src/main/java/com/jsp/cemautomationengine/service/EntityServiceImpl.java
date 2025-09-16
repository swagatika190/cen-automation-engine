package com.jsp.cemautomationengine.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.cemautomationengine.dto.AppResponseDto;
import com.jsp.cemautomationengine.dto.EntityDTO;
import com.jsp.cemautomationengine.entity.EntityModel;
import com.jsp.cemautomationengine.exception.CustomException;
import com.jsp.cemautomationengine.repository.EntityRepository;

@Service
public class EntityServiceImpl implements EntityService{
    
	@Autowired
	private EntityRepository repository;
	
	public EntityModel processDto(EntityDTO dto) {
		EntityModel model = new EntityModel();
		model.setEntityCode(dto.getEntityCode());
		model.setEntityName(dto.getEntityName());
		model.setEntityDescription(dto.getEntityDescription());
		model.setUniqueField(dto.getUniqueField());
		model.setStatusFieldsValues(dto.getStatusFieldsValues());
		model.setRemarks(dto.getRemarks());
		model.setCreatedBy(dto.getUserName());//manually set the value
		model.setCreatedDate(new Date());
		model.setModifiedBy("admin");
		model.setModifiedDate(new Date());
		
		return model;
		}

	@Override
	public AppResponseDto createEntity(EntityDTO entityDTO) {
		AppResponseDto response=null;
		try {
		EntityModel entityModel = repository.save(processDto(entityDTO));
		response=new AppResponseDto("Success","200",entityModel,null);
		}catch(CustomException e) {
			response=new AppResponseDto("Falure","500",null,e.getLocalizedMessage());	
		}
		return response;
	}

	@Override
	public List<EntityModel> getAllEntity() {	
		return repository.findAll();
	}

	@Override
	public EntityModel getEntityByEntityCode(String entityCode) {	
		return repository.findByEntityCode(entityCode);
	}

	@Override
	public EntityModel getEntityById(BigInteger altKey) {
		return repository.findById(altKey).get();
	}
	
	
	
	
	

}
