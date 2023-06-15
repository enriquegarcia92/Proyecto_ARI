package com.ari.backend.controller;

import com.ari.backend.model.JsonObject;
import com.ari.backend.service.json_textService;
import com.ari.backend.service.text_JsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/json_Text")

public class Json_TextController {

    @Autowired
    json_textService jsonTextService;
    @CrossOrigin(origins = "https://proyecto-ari.vercel.app/")
    @PostMapping("/convert/{key}")
    public ResponseEntity textToJson(@RequestBody JsonObject jsonObject, @PathVariable String key) {
        String textFileString = jsonTextService.jsonToText(jsonObject,key);
        return ResponseEntity.status(HttpStatus.CREATED).body(textFileString);
    }
}
