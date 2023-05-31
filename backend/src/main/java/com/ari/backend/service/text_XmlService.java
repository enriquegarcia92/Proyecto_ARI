package com.ari.backend.service;

import com.ari.backend.model.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
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
import java.util.ArrayList;
import java.util.List;

@Service
public class text_XmlService {
    public String convertTextToXml(String s) throws JsonProcessingException {

        String[] tokens = s.split(";");
        //Create an XmlMapper object
        XmlMapper xmlMapper = new XmlMapper();

        String xml = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tokens.length; i += 7) {
            XmlObject text = new XmlObject(tokens[i],tokens[i+1],tokens[i+2],tokens[i+3],tokens[i+4],tokens[i+5],tokens[i+6]);
            String xmlaux = xmlMapper.writeValueAsString(text);
            sb.append(xmlaux).append("\n");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }
}
