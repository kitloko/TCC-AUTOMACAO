package br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.controller;

import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Calculadora;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Complex.CalculadoraComplex;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Complex.CalculadoraComplexDto;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.CalculadoraDto;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.service.CalculadoraService;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.service.Complex.CalculadoraServiceComplex;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/calculadora")
@RequiredArgsConstructor
public class CalculadoraController {

    private final CalculadoraService calculadoraService;

    private final CalculadoraServiceComplex calculadoraServiceComplex;

    @PostMapping("/basica")
    @ResponseStatus(HttpStatus.OK)
    public CalculadoraDto basica(@RequestBody Calculadora calculadora) {
        return calculadoraService.calculadoraBasica(calculadora);
    }

    @PostMapping("/complex")
    @ResponseStatus(HttpStatus.OK)
    public CalculadoraComplexDto complex(@RequestBody CalculadoraComplex calculadoraComplex) {
        return calculadoraServiceComplex.calculadoraComplex(calculadoraComplex);
    }

}
