package com.jsp.cemautomationengine.service;

import com.jsp.cemautomationengine.context.NodeExecutionContext;
import com.jsp.cemautomationengine.result.NodeExecutionResult;

public class EndNodeServiceImpl implements NodeExecutionService {
  
	@Override
    public NodeExecutionResult execute(NodeExecutionContext context) {
        //  executing end node
        return new NodeExecutionResult();
    }
	
}
