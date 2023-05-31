package com.ari.backend.controller;

import com.ari.backend.model.JsonObject;
import com.ari.backend.model.XmlObject;
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
    public ResponseEntity textToJson(@RequestBody XmlObject xmlObject) throws Exception {
        String text = xmlTextService.convertXmlToText(xmlObject);
        return ResponseEntity.status(HttpStatus.CREATED).body(text);
    }
}
