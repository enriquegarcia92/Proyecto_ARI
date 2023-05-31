package com.ari.backend.service;

import com.ari.backend.model.XmlObject;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
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
    public String convertXmlToText(XmlObject xmlObject) {
        XmlObject auxobj = new XmlObject(xmlObject.getDui(),xmlObject.getName(),xmlObject.getLastname(),xmlObject.getCardNumber(),xmlObject.getType(),xmlObject.getPhone(),xmlObject.getPolygon());
        StringBuilder sb = new StringBuilder();
        sb.append(auxobj.getDui()).append(";");
        sb.append(auxobj.getName()).append(";");
        sb.append(auxobj.getLastname()).append(";");
        sb.append(auxobj.getCardNumber()).append(";");
        sb.append(auxobj.getType()).append(";");
        sb.append(auxobj.getPhone()).append(";");
        sb.append(auxobj.getPolygon()).append(";");

        return sb.substring(0, sb.length() - 1);
    }
}
