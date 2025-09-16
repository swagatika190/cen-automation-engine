package com.jsp.cemautomationengine.service;

import com.jsp.cemautomationengine.context.NodeExecutionContext;
import com.jsp.cemautomationengine.result.NodeExecutionResult;

public interface NodeExecutionService {
	NodeExecutionResult execute(NodeExecutionContext context);
}
