package com.ari.backend.controller;

import com.ari.backend.model.JsonObject;
import com.ari.backend.service.text_JsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/text_Json")
public class text_JsonController {

    @Autowired
    text_JsonService textJsonService;
    @PostMapping("/convert/{key}")
    public ResponseEntity textToJson(@RequestBody String textFileString, @PathVariable String key) throws Exception {
        List<JsonObject> jsonObject = textJsonService.convertTextToJson(textFileString,key);
        return ResponseEntity.status(HttpStatus.CREATED).body(jsonObject);
    }
}
