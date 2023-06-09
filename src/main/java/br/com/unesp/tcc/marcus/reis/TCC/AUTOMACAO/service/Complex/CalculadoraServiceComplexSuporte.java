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
        Double custoTotalProcesso = calculadora.getCustoSuporteSelenium();

        String[] split = calculadora.getTempoContratadoSuporteSelenium().split("\\.");
        String hora = split[0];
        String minuto = split[1];
        String tempo = String.valueOf(Integer.parseInt(hora) + 60) + Integer.parseInt(minuto);

        Double custoProcessoMinuto = (Double.parseDouble(tempo)) / calculadora.getCustoDesenvolvimentoSelenium();
        Double custoProcessoHora = custoProcessoMinuto / 60;

        if (calculadora.isCustoProcessoProd()) {
            calculadoraComplexDto.getSelenium().setSuporte(formatter.format(calculadora.getCustoProcesso() + custoTotalProcesso));
            calculadoraComplexDto.getSelenium().setGraficoSuporte(calculadora.getCustoProcesso() + custoTotalProcesso);
        } else {
            calculadoraComplexDto.getSelenium().setSuporte(formatter.format(custoTotalProcesso));
            calculadoraComplexDto.getSelenium().setGraficoSuporte(custoTotalProcesso);
        }
        calculadoraComplexDto.getSelenium().setTempoSuporte(tempo);
    }

    private void uipath(CalculadoraComplexDto calculadoraComplexDto, CalculadoraComplex calculadora) {
        Double custoTotalProcesso = calculadora.getCustoImplementacaoUipath() + calculadora.getCustoInfraUipath() + calculadora.getCustoTreinamentoUipath()+ calculadora.getCustoDocumentacaoUipath();

        String[] split = calculadora.getTempoContratadoSuporteSelenium().split("\\.");
        String hora = split[0];
        String minuto = split[1];
        String tempo = String.valueOf(Integer.parseInt(hora) + 60) + Integer.parseInt(minuto);

        Double custoProcessoMinuto = (Double.parseDouble(tempo)) / calculadora.getCustoDesenvolvimentoSelenium();
        Double custoProcessoHora = custoProcessoMinuto / 60;

        if (calculadora.isCustoProcessoProd()) {
            calculadoraComplexDto.getUipath().setSuporte(formatter.format(calculadora.getCustoProcesso() + custoTotalProcesso + calculadoraComplexDto.getUipath().getCustoMensalidade()));
            calculadoraComplexDto.getUipath().setGraficoSuporte(calculadora.getCustoProcesso() + custoTotalProcesso + calculadoraComplexDto.getUipath().getCustoMensalidade());
        } else {
            calculadoraComplexDto.getUipath().setSuporte(formatter.format(custoTotalProcesso + calculadoraComplexDto.getUipath().getCustoMensalidade()));
            calculadoraComplexDto.getUipath().setGraficoSuporte(custoTotalProcesso + calculadoraComplexDto.getUipath().getCustoMensalidade());
        }

        calculadoraComplexDto.getUipath().setTempoSuporte(tempo);
    }

}
