package br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.controller;

import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Calculadora;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.CalculadoraDto;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.service.CalculadoraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/calculadora")
@RequiredArgsConstructor
public class CalculadoraController {

    private final CalculadoraService calculadoraService;

    @PostMapping("/basica")
    @ResponseStatus(HttpStatus.OK)
    public CalculadoraDto basica(@RequestBody Calculadora calculadora) {
        return calculadoraService.calculadoraBasica(calculadora);
    }

}
