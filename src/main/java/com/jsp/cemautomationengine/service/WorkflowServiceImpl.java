package com.jsp.cemautomationengine.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.jsp.cemautomationengine.dto.AppResponseDto;
import com.jsp.cemautomationengine.dto.WorkflowDto;
import com.jsp.cemautomationengine.entity.NodeDetailsModel;
import com.jsp.cemautomationengine.entity.WorkflowModel;
import com.jsp.cemautomationengine.repository.NodeRepository;
import com.jsp.cemautomationengine.repository.WorkflowRepository;
import com.jsp.cemautomationengine.util.Handler;

import jakarta.persistence.EntityNotFoundException;

@Service
public class WorkflowServiceImpl implements WorkflowService {

	@Autowired
	private WorkflowRepository workflowRepository;
	@Autowired
	NodeRepository nodeRepository;
	
	private WorkflowModel getDraftWfByWfCode(String wfCode) {

	return workflowRepository.findByWfCodeAndStatusFlag(wfCode, "draft");
	}
	
	
	@Override
	public void processWorkflow(WorkflowDto workflowDTO) {
		
//		System.out.println("Service: Processing WorkflowDTO: " + workflowDTO);
//		System.out.println("Service: sourceData length: " + workflowDTO.getSourceData().length());
//		System.out.println("Service: entitycode: " + workflowDTO.getEntitycode());
//		System.out.println("Service: uniquefield: " + workflowDTO.getUniquefield());
//		

		if (workflowDTO.getOperationType().equalsIgnoreCase("CREATE")) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyy");
			String wf = workflowDTO.getWorkflowName() + "_" + simpleDateFormat.format(new Date());
			workflowDTO.setWfCode(wf);
		}
		
		WorkflowModel wf = getDraftWfByWfCode(workflowDTO.getWfCode());
		if (wf == null) {
			wf = new WorkflowModel();
			wf.setVersion(0);
			wf.setWfCode(workflowDTO.getWfCode());
			wf.setWfId((workflowDTO.getWfCode() + "_" + 0));
			wf.setWorkflowName(workflowDTO.getWorkflowName());
			wf.setStatusFlag(workflowDTO.getStatusFlag());
			wf.setEntitycode(workflowDTO.getEntitycode());
			wf.setUniquefield(workflowDTO.getUniquefield());
			wf.setSourceData(workflowDTO.getSourceData());
			wf.setWfDescription(workflowDTO.getWfDescription());
			wf.setCreatedDate(new Date());
			wf.setCreatedBy("admin");
			wf.setModifyedDate(new Date());
			wf.setModifiedBy("admin");
		}
		//System.out.println("Saving workflow with data: " + wf);
		workflowRepository.save(wf);			
	}


	@Override
	public AppResponseDto processUpdateStatus(Map<String, Object> statusMap) {
		    AppResponseDto response = null;

		    try {
		        if (!statusMap.containsKey("wfCode") || !statusMap.containsKey("status") || !statusMap.containsKey("wfId")) {
		            return new AppResponseDto("Failure", "400", null, "Required keys are missing in the statusMap.");
		        }

		        WorkflowModel model = workflowRepository.findByWfId((String) statusMap.get("wfId"));
		        if (model == null) {
		            return new AppResponseDto("Failure", "404", null, "Workflow with wfId " + statusMap.get("wfId") + " not found.");
		        }

		        Integer count = workflowRepository.findMaxVersionByWfCode(model.getWfCode());
		        List<WorkflowModel> list = workflowRepository.findByworkflowName(model.getWorkflowName());

		        for (WorkflowModel workflowModel : list) {
		            if (workflowModel.getStatusFlag().equalsIgnoreCase("draft")) {
		                workflowModel.setStatusFlag("active");
		                Handler h = new Handler();
		                
		                List<NodeDetailsModel> nodeList = h.convertWfXmlToNodeDetailsModel(workflowModel.getSourceData());
		                System.out.println("converted nodes: " + nodeList);//for testing 
		                
		                if (nodeList != null && !nodeList.isEmpty()) {
                            nodeRepository.saveAll(nodeList);
                            System.out.println("Nodes saved successfully: " + nodeList);                           
                        } else {
                            System.out.println("Node List is empty or null.");
                        }
		              
		               
		                count = increamentVersion(count);
		                workflowModel.setVersion(count);
		                workflowModel.setWfId(model.getWfCode() + "_" + count);
		                workflowRepository.save(workflowModel);

		                response = new AppResponseDto("Success", "200", workflowModel, null);
		            } else if (!workflowModel.getStatusFlag().equalsIgnoreCase("draft")) { // Change made here
		                workflowModel.setStatusFlag("inactive");
		                workflowRepository.save(workflowModel);
		            }
		        }
		    } catch (Exception e) {
		        response = new AppResponseDto("Failure", "500", null, "Internal server error: " + e.getMessage());
		    }
		    return response;
		}

		private int increamentVersion(int version) {
		    return ++version;
		}


	@Override
	public WorkflowModel getDraftByWfCode(String WfCode) {
		try {
			WorkflowModel model = workflowRepository.findByWfId(WfCode);
			return model;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
