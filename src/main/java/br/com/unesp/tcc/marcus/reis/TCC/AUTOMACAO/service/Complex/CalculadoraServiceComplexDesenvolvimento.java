package br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.service.Complex;

import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Calculadora;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Complex.CalculadoraComplex;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Complex.CalculadoraComplexDto;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Selenium;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Uipath;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;

@Service
public class CalculadoraServiceComplexDesenvolvimento {

    private final NumberFormat formatter = NumberFormat.getCurrencyInstance();

    public void calculadoraComplexDesenvolvimento(CalculadoraComplexDto calculadoraComplexDto, CalculadoraComplex calculadora) {
        selenium(calculadoraComplexDto, calculadora);
        uipath(calculadoraComplexDto, calculadora);
    }

    private void selenium(CalculadoraComplexDto calculadoraComplexDto, CalculadoraComplex calculadora) {
        Double custoDesenvolvimento = calculadora.getCustoDesenvolvimentoSelenium();
        Double custoSoftware = calculadora.getCustoSoftwareSelenium();
        String tempo = calculadora.getTempoDesenvolvimentoSelenium();

        Double custoTotalProcesso = desenvolvimentoSelenium(calculadora);

        if (calculadora.isCustoProcessoProd()) {
            calculadoraComplexDto.getSelenium().setTotalCustoDesenvolvendo(formatter.format(calculadora.getCustoProcesso() + custoTotalProcesso));
            calculadoraComplexDto.getSelenium().setGraficoDesenvolvendo(calculadora.getCustoProcesso() + custoTotalProcesso);
        } else {
            calculadoraComplexDto.getSelenium().setTotalCustoDesenvolvendo(formatter.format(custoTotalProcesso));
            calculadoraComplexDto.getSelenium().setGraficoDesenvolvendo(custoTotalProcesso);
        }
        calculadoraComplexDto.getSelenium().setCustoDesenvolvendo(formatter.format(custoDesenvolvimento));
        calculadoraComplexDto.getSelenium().setTempoDesenvolvendo((Integer.parseInt(tempo) / 8) + " dias");
        calculadoraComplexDto.getSelenium().setCustoSoftwareDesenvolvendo(formatter.format(custoSoftware));

    }

    private void uipath(CalculadoraComplexDto calculadoraComplexDto, CalculadoraComplex calculadora) {
        Double custoDesenvolvimento = calculadora.getCustoDesenvolvimentoUipath();
        Double custoSoftware = calculadora.getCustoSoftwareUipath();
        String tempo = calculadora.getTempoDesenvolvimentoUipath();

        Double custoTotalProcesso = desenvolvimentoUipath(calculadora);

        if (calculadora.isCustoProcessoProd()) {
            calculadoraComplexDto
                    .getUipath()
                    .setTotalCustoDesenvolvendo(
                            formatter.format(
                                    calculadora.getCustoProcesso()
                                            + custoTotalProcesso
                            )
                    );

            calculadoraComplexDto.getUipath().setGraficoDesenvolvendo(calculadora.getCustoProcesso() + custoTotalProcesso);
        } else {
            calculadoraComplexDto.getUipath().setTotalCustoDesenvolvendo(formatter.format(custoTotalProcesso));
            calculadoraComplexDto.getUipath().setGraficoDesenvolvendo(custoTotalProcesso);
        }

        calculadoraComplexDto.getUipath().setCustoDesenvolvendo(formatter.format(custoDesenvolvimento));
        calculadoraComplexDto.getUipath().setTempoDesenvolvendo((Integer.parseInt(tempo) / 8) + " dias");
        calculadoraComplexDto.getUipath().setCustoSoftwareDesenvolvendo(formatter.format(custoSoftware));


    }

    public double desenvolvimentoSelenium(CalculadoraComplex calculadora) {
        Double custoDesenvolvimento = calculadora.getCustoDesenvolvimentoSelenium();
        Double custoSoftware = calculadora.getCustoSoftwareSelenium();

        return custoDesenvolvimento + custoSoftware;
    }

    public double desenvolvimentoUipath(CalculadoraComplex calculadora) {
        Double custoDesenvolvimento = calculadora.getCustoDesenvolvimentoUipath();
        Double custoSoftware = calculadora.getCustoSoftwareUipath();
        return custoDesenvolvimento + custoSoftware;
    }



}
