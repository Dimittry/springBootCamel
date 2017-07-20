package com.example.demo.controller;

import com.example.demo.model.TestModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest", produces = MediaType.APPLICATION_XML_VALUE)
public class TestController {

    @RequestMapping("/xml")
    @ResponseBody
    public String postXml(@RequestBody TestModel testModel) {
        return "<root><subroot>one</subroot></root>";
    }

}
