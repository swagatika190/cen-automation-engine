package com.jsp.cemautomationengine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.cemautomationengine.constant.MappingConstants;
import com.jsp.cemautomationengine.dto.AppResponseDto;
import com.jsp.cemautomationengine.dto.EntityDTO;
import com.jsp.cemautomationengine.entity.EntityModel;
import com.jsp.cemautomationengine.service.EntityService;



@RestController
public class EntityController {
	
	@Autowired
	private EntityService service;

	@PostMapping(value=MappingConstants.CREATE_ENTITY)
	public @ResponseBody AppResponseDto createEntity(@RequestBody EntityDTO dto) {
	System.out.println("Received DTO: " + dto);
	return service.createEntity(dto);	
	}
	
	@GetMapping(value="/get")
	public EntityModel get(@RequestParam String entityCode) {
				EntityModel entityByEntityCode = service.getEntityByEntityCode(entityCode);
				System.out.println(entityByEntityCode);
				return entityByEntityCode;
	}


}
