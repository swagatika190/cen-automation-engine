package com.jsp.cemautomationengine.entity;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import com.jsp.cemautomationengine.converter.UniqueFieldConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="cem_entity")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntityModel {
	
	@Id	
	@Column(name="alt_key", columnDefinition = "BIGINT")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private BigInteger altKey;
	
	@Column(name="entity_code",unique=true)
	private String entityCode;
	
	@Column(name="entity_name")
	private String entityName;
	
	@Column(name="entity_description")
	private String entityDescription;
	
	@Column(name="unique_fields")
	@Convert(converter=UniqueFieldConverter.class)
	private List<Object> uniqueField;
	
	@Column(name="status_fields_values")
	@Convert(converter=UniqueFieldConverter.class)
	private List<Object> statusFieldsValues;
	
	@Column(name="remark")
	private String remarks;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="modified_date")
	private Date modifiedDate;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="modified_by")
	private String modifiedBy;
	
}
