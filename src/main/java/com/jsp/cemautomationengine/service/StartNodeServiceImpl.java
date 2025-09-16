package com.jsp.cemautomationengine.service;

import com.jsp.cemautomationengine.context.NodeExecutionContext;
import com.jsp.cemautomationengine.result.NodeExecutionResult;

public class StartNodeServiceImpl implements NodeExecutionService {
  
	@Override
    public NodeExecutionResult execute(NodeExecutionContext context) {
        // executing start node
        return new NodeExecutionResult();
    }
}
