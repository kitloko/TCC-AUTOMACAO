package br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.controller;

import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Calculadora;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/processo")
public class ProcessoController {

    @PostMapping("/form")
    public Calculadora endpoint(@RequestBody Calculadora calculadora) {
        return calculadora;
    }
}
