package com.ari.backend.service;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class xml_TextService {
    public String convertXmlToText(String xml) throws Exception{
        // Create a DocumentBuilderFactory object
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

        // Create a DocumentBuilder object
        DocumentBuilder db = dbFactory.newDocumentBuilder();

        // Parse the XML document
        Document doc = db.parse(new InputSource(new StringReader(xml)));

        // Create a TransformerFactory object
        TransformerFactory tf = TransformerFactory.newInstance();

        // Create a Transformer object
        Transformer transformer = tf.newTransformer();

        // Set the output property to be indenting
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        // Create a StringWriter object
        StringWriter sw = new StringWriter();

        // Create a StreamResult object
        StreamResult sr = new StreamResult(sw);

        // Transform the document to a string
        transformer.transform(new DOMSource(doc), sr);

        // Get the string value from the StringWriter object
        String output = sw.toString();

        // Create a regular expression object
        Pattern pattern = Pattern.compile("<[^>]+>");

        // Create a matcher object
        Matcher matcher = pattern.matcher(output);

        // Create a StringBuilder object
        StringBuilder sb = new StringBuilder();

        // While the matcher object finds a match
        while (matcher.find()) {

            // Append the match to the StringBuilder object
            sb.append(matcher.group());
        }

        // Get the string value from the StringBuilder object
        String finalOutput = sb.toString();

        // Return the output string
        return finalOutput;
    }
}
