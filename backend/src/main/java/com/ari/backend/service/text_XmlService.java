package com.ari.backend.service;

import com.ari.backend.model.*;
import com.ari.backend.utils.vinegere;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Service;
@Service
public class text_XmlService {
    public String convertTextToXml(String s,String key) throws JsonProcessingException {

        String[] tokens = s.split(";");
        //Create an XmlMapper object
        XmlMapper xmlMapper = new XmlMapper();

        String xml = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tokens.length; i += 7) {
            String cardCypher = vinegere.encrypt(tokens[i+3],key);
            XmlObject text = new XmlObject(tokens[i],tokens[i+1],tokens[i+2],cardCypher,tokens[i+4],tokens[i+5],tokens[i+6]);
            String xmlaux = xmlMapper.writeValueAsString(text);
            sb.append(xmlaux).append("\n");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }
}
