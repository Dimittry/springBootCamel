package com.example.demo.service;

import com.example.demo.model.TestModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Service
public class TestService {

    public String test() {
        return "test";
    }

    @ResponseBody
    public Map<String, Object> testGetParam(int id) {
//        return new ResponseEntity<String>("body", HttpStatus.OK);
        Map<String, Object> map = new HashMap<>();
        map.put("one", "one");
        return map;
    }

    @ResponseBody
    public Map<String, Object> testPostParam(Map<String, Object> map) {
//        return new ResponseEntity<String>("body", HttpStatus.OK);
        map.put("name", "POpa");
        return map;
    }

    @ResponseBody
    public TestModel testPostXmlParam(TestModel model) {
//        return new ResponseEntity<String>("body", HttpStatus.OK);
        model.setName("newName");
        model.setDesc("newDesc");
        return model;
    }

    public String testPost() {
        return "test post";
    }
}
