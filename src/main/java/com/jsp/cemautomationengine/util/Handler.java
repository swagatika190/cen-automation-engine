package com.jsp.cemautomationengine.util;


import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.springframework.stereotype.Component;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.jsp.cemautomationengine.entity.NodeDetailsModel;

@Component
public class Handler {

	private NodeDetailsModel currentNodeDetails;

	public List<NodeDetailsModel> convertWfXmlToNodeDetailsModel(String xmlString)
			throws SAXException, IOException, ParserConfigurationException {

		final List<NodeDetailsModel> nodeDetailsList = new ArrayList<>();
		final Map<String, String[]> sequenceFlows = new HashMap<>();

		// Trim leading/trailing whitespace and ensure the XML string starts correctly
		xmlString = xmlString.trim();
		if (!xmlString.startsWith("<?xml")) {
			xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + xmlString;
		}

		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();

		saxParser.parse(new InputSource(new StringReader(xmlString)), new DefaultHandler() {
			private boolean insideProcess = false;
			private boolean insideIncoming = false;
			private boolean insideOutgoing = false;
			private StringBuilder currentText = new StringBuilder();

			@Override
			public void startElement(String uri, String localName, String qName, Attributes attributes)
					throws SAXException {
				if (qName.equals("process")) {
					insideProcess = true;
				} else if (insideProcess
						&& (qName.equals("startEvent") || qName.equals("endEvent") || qName.equals("task"))) {
					if (currentNodeDetails != null) {
						// Add the previous nodeDetails to the list before creating a new one
						nodeDetailsList.add(currentNodeDetails);
					}
					currentNodeDetails = new NodeDetailsModel();
					currentNodeDetails.setNodeId(attributes.getValue("id"));
					currentNodeDetails.setNodeType(qName); // "startEvent", "endEvent", or "task"
					currentNodeDetails.setNodeProperties(new HashMap<>());
				} else if (insideProcess && qName.equals("incoming")) {
					insideIncoming = true;
					currentText.setLength(0); // Reset current text
				} else if (insideProcess && qName.equals("outgoing")) {
					insideOutgoing = true;
					currentText.setLength(0); // Reset current text
				} else if (insideProcess && qName.equals("sequenceFlow")) {
					String flowId = attributes.getValue("id");
					String sourceRef = attributes.getValue("sourceRef");
					String targetRef = attributes.getValue("targetRef");
					sequenceFlows.put(flowId, new String[] { sourceRef, targetRef });
				}
			}

			@Override
			public void endElement(String uri, String localName, String qName) throws SAXException {
				if (qName.equals("incoming")) {
					insideIncoming = false;
					if (currentNodeDetails != null) {
						// Add the accumulated text to incomingNodes
						List<String> incomingNodes = currentNodeDetails.getIncomingNodes();
						if (incomingNodes == null) {
							incomingNodes = new ArrayList<>();
						}
						incomingNodes.add(currentText.toString().trim());
						currentNodeDetails.setIncomingNodes(incomingNodes);
					}
				} else if (qName.equals("outgoing")) {
					insideOutgoing = false;
					if (currentNodeDetails != null) {
						// Add the accumulated text to outgoingNodes
						List<String> outgoingNodes = currentNodeDetails.getOutgoingNodes();
						if (outgoingNodes == null) {
						outgoingNodes = new ArrayList<>();
					}
						outgoingNodes.add(currentText.toString().trim());
						currentNodeDetails.setOutgoingNodes(outgoingNodes);
					}
				} else if (qName.equals("startEvent") || qName.equals("endEvent") || qName.equals("task")) {
					if (currentNodeDetails != null) {
						nodeDetailsList.add(currentNodeDetails);
						currentNodeDetails = null;
					}
				} else if (qName.equals("process")) {
					insideProcess = false;
				}
				currentText.setLength(0); // Reset current text
			}

			@Override
			public void characters(char[] ch, int start, int length) throws SAXException {
				currentText.append(new String(ch, start, length));
			}
		});

		// Add the last nodeDetails if not already added
		if (currentNodeDetails != null) {
			nodeDetailsList.add(currentNodeDetails);
		}
     
		System.out.println("Converted Nodes: " + nodeDetailsList);//for testing
		return nodeDetailsList;
	}
}
