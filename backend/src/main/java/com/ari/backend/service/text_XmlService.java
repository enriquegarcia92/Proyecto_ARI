package com.ari.backend.service;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

@Service
public class text_XmlService {
    public static String convertTextToXml(String inputString) throws ParserConfigurationException, TransformerException {
        // Create a DocumentBuilderFactory instance.
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Create a DocumentBuilder instance.
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Create a Document instance.
        Document document = builder.newDocument();

        // Create the element `data`.
        Element data = document.createElement("data");

        // Create child elements.
        for (String value : inputString.split(";")) {
            Element childElement = document.createElement("value");
            childElement.setTextContent(value);
            data.appendChild(childElement);
        }

        // Convert the Document instance to a string.
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(document), new StreamResult(writer));
        // Return the string.
        return writer.toString().replaceAll("\n", "");
    }
}
