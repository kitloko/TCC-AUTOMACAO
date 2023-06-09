package br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.service.Complex;

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

        String[] split = calculadora.getTempoDesenvolvimentoSelenium().split("\\.");
        String hora = split[0];
        String minuto = split[1];
        String tempo = String.valueOf(Integer.parseInt(hora) + 60) + Integer.parseInt(minuto);

        Double custoProcessoMinuto = (Double.parseDouble(tempo)) / calculadora.getCustoDesenvolvimentoSelenium();
        Double custoProcessoHora = custoProcessoMinuto / 60;

        Double custoTotalProcesso = custoDesenvolvimento + custoSoftware;

        if (calculadora.isCustoProcessoProd()) {
            calculadoraComplexDto.getSelenium().setDesenvolvendo(formatter.format(calculadora.getCustoProcesso() + custoTotalProcesso));
            calculadoraComplexDto.getSelenium().setGraficoDesenvolvendo(calculadora.getCustoProcesso() + custoTotalProcesso);
        } else {
            calculadoraComplexDto.getSelenium().setDesenvolvendo(formatter.format(custoTotalProcesso));
            calculadoraComplexDto.getSelenium().setGraficoDesenvolvendo(custoTotalProcesso);
        }
        calculadoraComplexDto.getSelenium().setTempoDesenvolvendo(tempo);
    }

    private void uipath(CalculadoraComplexDto calculadoraComplexDto, CalculadoraComplex calculadora) {
        Double custoDesenvolvimento = calculadora.getCustoDesenvolvimentoUipath();
        Double custoSoftware = calculadora.getCustoSoftwareUipath();

        String[] split = calculadora.getTempoDesenvolvimentoUipath().split("\\.");
        String hora = split[0];
        String minuto = split[1];
        String tempo = String.valueOf(Integer.parseInt(hora) + 60) + Integer.parseInt(minuto);

        Double custoProcessoMinuto = (Double.parseDouble(tempo)) / calculadora.getCustoDesenvolvimentoUipath();
        Double custoProcessoHora = custoProcessoMinuto / 60;

        Double custoTotalProcesso = custoDesenvolvimento + custoSoftware;

        if (calculadora.isCustoProcessoProd()) {
            calculadoraComplexDto
                    .getUipath()
                    .setDesenvolvendo(
                            formatter.format(
                                    calculadora.getCustoProcesso()
                                            + custoTotalProcesso
                                            + calculadoraComplexDto.getUipath().getCustoMensalidade()
                            )
                    );

            calculadoraComplexDto.getUipath().setGraficoDesenvolvendo(calculadora.getCustoProcesso() + custoTotalProcesso + calculadoraComplexDto.getUipath().getCustoMensalidade());
        } else {
            calculadoraComplexDto.getUipath().setDesenvolvendo(formatter.format(custoTotalProcesso + calculadoraComplexDto.getUipath().getCustoMensalidade()));
            calculadoraComplexDto.getUipath().setGraficoDesenvolvendo(custoTotalProcesso + calculadoraComplexDto.getUipath().getCustoMensalidade());
        }

        calculadoraComplexDto.getUipath().setTempoDesenvolvendo(tempo);
    }


}
