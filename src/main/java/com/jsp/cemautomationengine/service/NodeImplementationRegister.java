package com.jsp.cemautomationengine.service;

import java.util.HashMap;
import java.util.Map;

public class NodeImplementationRegister {

	
	private final Map<String, String> nodeTypeToImplementationClass = new HashMap<>();

    public NodeImplementationRegister() {
        nodeTypeToImplementationClass.put("startNode", StartNodeServiceImpl.class.getName());
        nodeTypeToImplementationClass.put("endNode", EndNodeServiceImpl.class.getName());
    }

    public NodeExecutionService getNodeExecutionService(String nodeType) {
        String implementationClassName = nodeTypeToImplementationClass.get(nodeType);
        try {
            return (NodeExecutionService)Class.forName(implementationClassName).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create instance for node type: " + nodeType, e);
        }
    }
}
