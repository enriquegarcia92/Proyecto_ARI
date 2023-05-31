package com.ari.backend.controller;

import com.ari.backend.model.JsonObject;
import com.ari.backend.service.text_XmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    @PostMapping(path = "/convert", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity textToJson(@RequestBody String textFileString) throws Exception {
        String xml = textXmlService.convertTextToXml(textFileString);
        return ResponseEntity.status(HttpStatus.CREATED).body(xml);
    }
}
