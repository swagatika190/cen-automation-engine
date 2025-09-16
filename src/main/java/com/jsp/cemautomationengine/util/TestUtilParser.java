package com.jsp.cemautomationengine.util;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class TestUtilParser extends DefaultHandler {
    private StringBuilder xmlContent = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        xmlContent.append("<").append(qName).append(">");
        for (int i = 0; i < attributes.getLength(); i++) {
            xmlContent.append(" ").append(attributes.getQName(i)).append("=\"").append(attributes.getValue(i)).append("\"");
        }
        xmlContent.append(">");
    }

    @Override
   public void endElement(String uri, String localName, String qName) throws SAXException {
        xmlContent.append("</").append(qName).append(">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        xmlContent.append(new String(ch, start, length));
    }

    public String getXmlContent() {
        return xmlContent.toString();
    }
}

