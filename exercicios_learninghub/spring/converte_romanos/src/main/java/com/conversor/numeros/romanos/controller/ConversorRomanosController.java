package com.conversor.numeros.romanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("coversor")
public class ConversorRomanosController {

    @GetMapping(path = "/{algarismo}")
    public String helloWorld() {
        return "Hello world";
    }
}
