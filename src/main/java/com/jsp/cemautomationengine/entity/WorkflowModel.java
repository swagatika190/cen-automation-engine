package com.jsp.cemautomationengine.entity;

import java.math.BigInteger;
//import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.jsp.cemautomationengine.config.NodeConfig;
import com.jsp.cemautomationengine.config.NodeConfigBuilder;

import jakarta.persistence.Column;
//import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name="cem_workflow")
@Data
public class WorkflowModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "alt_key", columnDefinition = "BIGINT")
	private BigInteger altkey;
	
	private List<NodeDetailsModel> workflowNodeDetails;

	@Column(name = "version")
	private Integer version;

	@Column(name = "wf_code")
	private String wfCode;

	@Column(name = "wf_id")
	private String wfId;

	@Column(name = "wf_name")
	private String workflowName;

	@Column(name = "status_flag")
	private String statusFlag;

	@Column(name = "entity_code")
	private String entitycode;

	@Column(name = "unique_fields")
	private String uniquefield;

	@Column(name = "source_data" ,columnDefinition = "LONGTEXT")
	private String sourceData;

	@Column(name = "wf_description")
	private String wfDescription;

	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "modifyed_date")
	private Date modifyedDate;

	@Column(name = "modified_by")
	private String modifiedBy;
	
	
	public List<NodeConfig> getStartNodeConfig(){
		List<NodeConfig> nodeConfigList = new NodeConfigBuilder().getNodeConfig(workflowNodeDetails);
		return nodeConfigList.stream().filter(nodeConfig -> "start".equals(nodeConfig.getNodeType())).collect(Collectors.toList());
	}
	
	public List<NodeConfig> getAllNodeConfig() {
        return new NodeConfigBuilder().getNodeConfig(workflowNodeDetails);
    }
	
//	// Convert List<String> to a String
//	public void setUniquefield(List<String> uniquefield) { 
//		this.uniquefield = String.join(",", uniquefield); 
//		}
//	
//	// Convert  String back to List<String> 
//	public List<String> getUniquefield() { 
//		return Arrays.asList(this.uniquefield.split(","));
//		}
}
