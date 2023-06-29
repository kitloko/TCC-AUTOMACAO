package br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class FrontEndController {

    @GetMapping("")
    public String home() {
        return "index.html";
    }

    @GetMapping("complex")
    public String complex() {
        return "CalculadoraComplex.html";
    }

    @GetMapping("basic")
    public String basic() {
        return "Calculadora.html";
    }
}
