package com.jsp.cemautomationengine.entity;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.hibernate.annotations.JdbcTypeCode;

import com.jsp.cemautomationengine.converter.MapToStringConverter;
import com.jsp.cemautomationengine.converter.UniqueFieldConverter;
import com.jsp.cemautomationengine.converter.ConverterClass;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="cem_node_details")
@Data
public class NodeDetailsModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="alt_key", columnDefinition = "BIGINT")
	private BigInteger nodeAltKey;
	
	@Column(name="node_id")
	private String nodeId;
	
	@Column(name="node_type")
	private String nodeType;
	
	@Column(name="wf_id")
	private String wfId;
	
	@Column(name="outgoing_node")
	@Convert(converter=ConverterClass.class)
	private List<String> outgoingNodes;
	
	@Column(name="incoming_nodes")
	@Convert(converter=ConverterClass.class)
	private List<String> incomingNodes;
	
	@Column(name="node_properties")
	//@JdbcTypeCode(12)
	@Convert(converter=MapToStringConverter.class)
	private Map<String,String> nodeProperties;
	
}
