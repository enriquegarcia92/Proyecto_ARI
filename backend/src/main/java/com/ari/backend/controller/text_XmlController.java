package com.ari.backend.controller;

import com.ari.backend.model.JsonObject;
import com.ari.backend.service.text_XmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.util.List;

@RestController
@RequestMapping("/text_Xml")
public class text_XmlController {

    @Autowired
    text_XmlService textXmlService;
    @PostMapping("/convert")
    public String textToJson(@RequestBody String textFileString) throws ParserConfigurationException, TransformerException {
        String Xml = textXmlService.convertTextToXml(textFileString);
        return Xml;
    }
}
