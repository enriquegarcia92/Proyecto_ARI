package com.ari.backend.controller;

import com.ari.backend.model.JsonObject;
import com.ari.backend.model.XmlObject;
import com.ari.backend.service.xml_TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/xml_text")
public class xml_TextController {

    @Autowired
    xml_TextService xmlTextService;
    @CrossOrigin(origins = "https://proyecto-ari.vercel.app/")
    @PostMapping("/convert/{key}")
    public ResponseEntity textToJson(@RequestBody XmlObject xmlObject, @PathVariable String key) throws Exception {
        String text = xmlTextService.convertXmlToText(xmlObject,key);
        return ResponseEntity.status(HttpStatus.CREATED).body(text);
    }
}
