package com.ari.backend.controller;

import com.ari.backend.model.JsonObject;
import com.ari.backend.service.xml_TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/xml_text")
public class xml_TextController {

    @Autowired
    xml_TextService xmlTextService;
    @PostMapping("/convert")
    public ResponseEntity textToJson(@RequestBody String xmlFileString) throws Exception {
        String xml = "<XmlObject><dui>06044102-0</dui><name>José Enrique</name><lastname>García Arévalo</lastname><cardNumber>4112011600079281</cardNumber><type>GOLD</type><polygon>-90.76,17.9991</polygon><phone>70829262</phone></XmlObject>";
        String text = xmlTextService.convertXmlToText(xml);
        return ResponseEntity.status(HttpStatus.CREATED).body(text);
    }
}
