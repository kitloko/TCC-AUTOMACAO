package br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.service.Complex;

import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Complex.CalculadoraComplex;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Complex.CalculadoraComplexDto;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Selenium;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Uipath;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;

@Service
public class CalculadoraServiceComplexImplementacao {

    private final NumberFormat formatter = NumberFormat.getCurrencyInstance();

    public void calculadoraComplexImplementacao(CalculadoraComplexDto calculadoraComplexDto, CalculadoraComplex calculadora) {
        selenium(calculadoraComplexDto, calculadora);
        uipath(calculadoraComplexDto, calculadora);
    }

    private void selenium(CalculadoraComplexDto calculadoraComplexDto, CalculadoraComplex calculadora) {
        Double custoTotalProcesso = calculadora.getCustoImplementacaoSelenium() + calculadora.getCustoInfraSelenium() + calculadora.getCustoTreinamentoSelenium()+ calculadora.getCustoDocumentacaoSelenium();

        if (calculadora.isCustoProcessoProd()) {
            calculadoraComplexDto.getSelenium().setImplementacao(formatter.format(calculadora.getCustoProcesso() + custoTotalProcesso));
            calculadoraComplexDto.getSelenium().setGraficoImplementacao(calculadora.getCustoProcesso() + custoTotalProcesso);
        } else {
            calculadoraComplexDto.getSelenium().setImplementacao(formatter.format(custoTotalProcesso));
            calculadoraComplexDto.getSelenium().setGraficoImplementacao(custoTotalProcesso);
        }
    }

    private void uipath(CalculadoraComplexDto calculadoraComplexDto, CalculadoraComplex calculadora) {
        Double custoTotalProcesso = calculadora.getCustoImplementacaoUipath() + calculadora.getCustoInfraUipath() + calculadora.getCustoTreinamentoUipath()+ calculadora.getCustoDocumentacaoUipath();

        if (calculadora.isCustoProcessoProd()) {
            calculadoraComplexDto.getUipath().setImplementacao(formatter.format(calculadora.getCustoProcesso() + custoTotalProcesso + calculadoraComplexDto.getUipath().getCustoMensalidade()));
            calculadoraComplexDto.getUipath().setGraficoImplementacao(calculadora.getCustoProcesso() + custoTotalProcesso + calculadoraComplexDto.getUipath().getCustoMensalidade());
        } else {
            calculadoraComplexDto.getUipath().setImplementacao(formatter.format(custoTotalProcesso + calculadoraComplexDto.getUipath().getCustoMensalidade()));
            calculadoraComplexDto.getUipath().setGraficoImplementacao(custoTotalProcesso + calculadoraComplexDto.getUipath().getCustoMensalidade());
        }
    }

}
