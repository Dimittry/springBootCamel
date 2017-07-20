package com.example.demo.route;

import com.example.demo.model.TestModel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.stereotype.Component;

import java.util.HashMap;

import static org.apache.camel.model.rest.RestParamType.body;

/**
 * Created by Dimon on 20.07.2017.
 */
@Component
public class MainRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        // @formatter:off
        restConfiguration()
                .component("servlet")
                .bindingMode(RestBindingMode.json)
                .dataFormatProperty("prettyPrint", "true")
                .apiContextPath("/api-doc")
                .apiProperty("api.title", "binbank API").apiProperty("api.version", "1.0.0")
                .apiProperty("cors", "true")
                .enableCORS(true);
        rest("/test")
                .get()
                .responseMessage().code(200).message("Платеж успешно найден").endResponseMessage()
                .to("bean:testService?method=test")

                .get("/{id}")
                .responseMessage().code(200).message("Платеж успешно найден").endResponseMessage()
                .to("bean:testService?method=testGetParam(${header.id})")

                .post("/{id}")
                .responseMessage().code(200).message("Платеж успешно найден").endResponseMessage()
                .type(HashMap.class)
                .param().name("body").type(body).description("платеж для расчета коммиссии").endParam()
                .to("bean:testService?method=testPostParam")

                .post("/xml")
                .bindingMode(RestBindingMode.xml)
                .consumes(org.springframework.http.MediaType.APPLICATION_XML_VALUE)
                .responseMessage().code(200).message("Платеж успешно найден").endResponseMessage()
                .type(TestModel.class)
                .param().name("body").type(body).description("платеж для расчета коммиссии").endParam()
                .to("bean:testService?method=testPostXmlParam")


                .post()
                .responseMessage().code(200).message("Платеж успешно найден").endResponseMessage()
                .to("bean:testService?method=testPost");

    }
}