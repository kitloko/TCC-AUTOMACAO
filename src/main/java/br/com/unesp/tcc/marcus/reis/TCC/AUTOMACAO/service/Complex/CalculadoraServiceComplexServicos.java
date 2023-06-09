package br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.service.Complex;

import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Complex.CalculadoraComplex;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Complex.CalculadoraComplexDto;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;

@Service
public class CalculadoraServiceComplexServicos {

    private final NumberFormat formatter = NumberFormat.getCurrencyInstance();

    public void calculadoraComplexSuporte(CalculadoraComplexDto calculadoraComplexDto, CalculadoraComplex calculadora) {
    }

    private void selenium(CalculadoraComplexDto calculadoraComplexDto, CalculadoraComplex calculadora) {

    }

    private void uipath(CalculadoraComplexDto calculadoraComplexDto, CalculadoraComplex calculadora) {

    }

}
