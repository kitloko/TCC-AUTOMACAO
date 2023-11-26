package br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.service.Complex;

import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Complex.CalculadoraComplex;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Complex.CalculadoraComplexDto;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;

@Service
public class CalculadoraServiceComplexSuporte {

    private final NumberFormat formatter = NumberFormat.getCurrencyInstance();

    public void calculadoraComplexSuporte(CalculadoraComplexDto calculadoraComplexDto, CalculadoraComplex calculadora) {
        selenium(calculadoraComplexDto, calculadora);
        uipath(calculadoraComplexDto, calculadora);
    }

    private void selenium(CalculadoraComplexDto calculadoraComplexDto, CalculadoraComplex calculadora) {
        Double custoTotalSuporte = retornaSuporteSelenium(calculadora);
        String tempo = calculadora.getTempoContratadoSuporteSelenium();


        calculadoraComplexDto.getSelenium().setCustoSuporte(formatter.format(custoTotalSuporte));
        calculadoraComplexDto.getSelenium().setGraficoSuporte(custoTotalSuporte);
        calculadoraComplexDto.getSelenium().setTempoContratadoSup((Integer.parseInt(tempo) / 8) + " dias");
    }

    private void uipath(CalculadoraComplexDto calculadoraComplexDto, CalculadoraComplex calculadora) {
        Double custoTotalSuporte = retornaSuporteUipath(calculadora);
        String tempo = calculadora.getTempoContratadoSuporteUipath();

        calculadoraComplexDto.getUipath().setCustoSuporte(formatter.format(custoTotalSuporte));
        calculadoraComplexDto.getUipath().setGraficoSuporte(custoTotalSuporte);

        calculadoraComplexDto.getUipath().setTempoContratadoSup((Integer.parseInt(tempo) / 8) + " dias");
    }

    public double retornaSuporteSelenium(CalculadoraComplex calculadora) {
        return calculadora.getCustoSuporteSelenium();
    }

    public double retornaSuporteUipath(CalculadoraComplex calculadora) {
        return calculadora.getCustoSuporteUipath();


    }

}
