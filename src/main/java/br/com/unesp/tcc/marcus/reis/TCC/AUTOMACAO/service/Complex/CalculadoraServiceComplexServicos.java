package br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.service.Complex;

import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Complex.CalculadoraComplex;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;

@Service
public class CalculadoraServiceComplexServicos {

    private final NumberFormat formatter = NumberFormat.getCurrencyInstance();

    public void calculadoraBasicaAutomation(CalculadoraComplex calculadora) {
        calculadora.getCustoDesenvolvimento();
        calculadora.getTempoDesenvolvimento();
        calculadora.getCustoSoftware();
    }

}
