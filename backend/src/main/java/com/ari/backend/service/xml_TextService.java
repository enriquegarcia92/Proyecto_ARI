package com.ari.backend.service;

import com.ari.backend.model.XmlObject;
import com.ari.backend.utils.vinegere;
import org.springframework.stereotype.Service;

@Service
public class xml_TextService {
    public String convertXmlToText(XmlObject xmlObject, String key) {
        String cardDecypher = vinegere.decrypt(xmlObject.getCardNumber(),key);
        XmlObject auxobj = new XmlObject(xmlObject.getDui(),xmlObject.getName(),xmlObject.getLastname(),cardDecypher,xmlObject.getType(),xmlObject.getPhone(),xmlObject.getPolygon());
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
