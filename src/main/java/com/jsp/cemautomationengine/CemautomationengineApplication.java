package com.jsp.cemautomationengine;

import java.io.StringReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.xml.sax.InputSource;

import com.jsp.cemautomationengine.util.TestUtilParser;

@SpringBootApplication
public class CemautomationengineApplication {

	public static void main(String[] args) {
		SpringApplication.run(CemautomationengineApplication.class, args);
		
//		   // XML content
//        String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
//                + "<bpmn:definitions xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:bpmn=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\" id=\"Definitions_07ddqki\" targetNamespace=\"http://bpmn.io/schema/bpmn\" exporter=\"bpmn-js (https://demo.bpmn.io)\" exporterVersion=\"18.1.1\">"
//                + "  <bpmn:process id=\"Process_1g3nrn3\" isExecutable=\"false\">"
//                + "    <bpmn:startEvent id=\"StartEvent_04xoyo0\" name=\"start\">"
//                + "      <bpmn:outgoing>Flow_0han5r4</bpmn:outgoing>"
//                + "    </bpmn:startEvent>"
//                + "    <bpmn:task id=\"Activity_0smiuha\" name=\"service\">"
//                + "      <bpmn:incoming>Flow_0han5r4</bpmn:incoming>"
//                + "      <bpmn:outgoing>Flow_1mapj5c</bpmn:outgoing>"
//                + "    </bpmn:task>"
//                + "    <bpmn:sequenceFlow id=\"Flow_0han5r4\" sourceRef=\"StartEvent_04xoyo0\" targetRef=\"Activity_0smiuha\" />"
//                + "    <bpmn:exclusiveGateway id=\"Gateway_0h5msi3\">"
//                + "      <bpmn:incoming>Flow_1mapj5c</bpmn:incoming>"
//                + "      <bpmn:outgoing>Flow_1dw8qas</bpmn:outgoing>"
//                + "      <bpmn:outgoing>Flow_1h4esjw</bpmn:outgoing>"
//                + "    </bpmn:exclusiveGateway>"
//                + "    <bpmn:sequenceFlow id=\"Flow_1mapj5c\" sourceRef=\"Activity_0smiuha\" targetRef=\"Gateway_0h5msi3\" />"
//                + "    <bpmn:task id=\"Activity_1lqovqp\" name=\"failure\">"
//                + "      <bpmn:incoming>Flow_1dw8qas</bpmn:incoming>"
//                + "      <bpmn:outgoing>Flow_0l2nf49</bpmn:outgoing>"
//               + "    </bpmn:task>"
//                + "    <bpmn:sequenceFlow id=\"Flow_1dw8qas\" sourceRef=\"Gateway_0h5msi3\" targetRef=\"Activity_1lqovqp\" />"
//                + "    <bpmn:endEvent id=\"Event_0wzzpyd\" name=\"end\">"
//                + "      <bpmn:incoming>Flow_1vyds8a</bpmn:incoming>"
//                + "    </bpmn:endEvent>"
//                + "    <bpmn:endEvent id=\"Event_0oj3gwu\" name=\"end\">"
//                + "      <bpmn:incoming>Flow_0l2nf49</bpmn:incoming>"
//                + "    </bpmn:endEvent>"
//                + "    <bpmn:sequenceFlow id=\"Flow_0l2nf49\" sourceRef=\"Activity_1lqovqp\" targetRef=\"Event_0oj3gwu\" />"
//                + "    <bpmn:task id=\"Activity_056jf75\" name=\"success\">"
//               + "      <bpmn:incoming>Flow_1h4esjw</bpmn:incoming>"
//                + "      <bpmn:outgoing>Flow_1vyds8a</bpmn:outgoing>"
//                + "    </bpmn:task>"
//                + "    <bpmn:sequenceFlow id=\"Flow_1h4esjw\" sourceRef=\"Gateway_0h5msi3\" targetRef=\"Activity_056jf75\" />"
//                + "    <bpmn:sequenceFlow id=\"Flow_1vyds8a\" sourceRef=\"Activity_056jf75\" targetRef=\"Event_0wzzpyd\" />"
//                + "  </bpmn:process>"
//                + "</bpmn:definitions>";
//
//        try {
//            SAXParserFactory factory = SAXParserFactory.newInstance();
//            SAXParser saxParser = factory.newSAXParser();
//            TestUtilParser testUtilParser = new TestUtilParser();
//
//            saxParser.parse(new InputSource(new StringReader(xmlString)), testUtilParser);
//
//            // Output the parsed XML content
//            System.out.println(testUtilParser.getXmlContent());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
	
}

