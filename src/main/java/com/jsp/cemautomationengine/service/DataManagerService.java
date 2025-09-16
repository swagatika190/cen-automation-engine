package com.jsp.cemautomationengine.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class DataManagerService {
	   @Autowired
	    private JdbcTemplate jdbcTemplate;
	  
	    public Map<String, Object> getSingleTransactionData(String entityName, String selectField, String uniqueField, String transactionUniqueValue) {
	        String sql = String.format("SELECT %s FROM %s WHERE %s = ?", selectField, entityName, uniqueField);
	        return jdbcTemplate.queryForMap(sql, transactionUniqueValue);
	    }
}
