package br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.service.Complex;

import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Complex.CalculadoraComplex;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Complex.CalculadoraComplexDto;
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
        Double custoTotalProcesso = implementacaoSelenium(calculadora);

        if (calculadora.isCustoProcessoProd()) {
            calculadoraComplexDto.getSelenium().setTotalCustoImplementacao(formatter.format(calculadora.getCustoProcesso() + custoTotalProcesso));
            calculadoraComplexDto.getSelenium().setGraficoImplementacao(calculadora.getCustoProcesso() + custoTotalProcesso);
        } else {
            calculadoraComplexDto.getSelenium().setTotalCustoImplementacao(formatter.format(custoTotalProcesso));
            calculadoraComplexDto.getSelenium().setGraficoImplementacao(custoTotalProcesso);
        }
        calculadoraComplexDto.getSelenium().setCustoImplementacao(formatter.format(calculadora.getCustoImplementacaoSelenium()));
        calculadoraComplexDto.getSelenium().setCustoInfra(formatter.format(calculadora.getCustoInfraSelenium()));
        calculadoraComplexDto.getSelenium().setCustoTreinamento(formatter.format(calculadora.getCustoTreinamentoSelenium()));
        calculadoraComplexDto.getSelenium().setCustoDocumentacao(formatter.format(calculadora.getCustoDocumentacaoSelenium()));
    }

    private void uipath(CalculadoraComplexDto calculadoraComplexDto, CalculadoraComplex calculadora) {
        Double custoTotalProcesso = implementacaoUipath(calculadora);

        if (calculadora.isCustoProcessoProd()) {
            calculadoraComplexDto.getUipath().setTotalCustoImplementacao(formatter.format(calculadora.getCustoProcesso()));
            calculadoraComplexDto.getUipath().setGraficoImplementacao(calculadora.getCustoProcesso() + custoTotalProcesso);
        } else {
            calculadoraComplexDto.getUipath().setTotalCustoImplementacao(formatter.format(custoTotalProcesso));
            calculadoraComplexDto.getUipath().setGraficoImplementacao(custoTotalProcesso);
        }

        calculadoraComplexDto.getUipath().setCustoImplementacao(formatter.format(calculadora.getCustoImplementacaoUipath()));
        calculadoraComplexDto.getUipath().setCustoInfra(formatter.format(calculadora.getCustoInfraUipath()));
        calculadoraComplexDto.getUipath().setCustoTreinamento(formatter.format(calculadora.getCustoTreinamentoUipath()));
        calculadoraComplexDto.getUipath().setCustoDocumentacao(formatter.format(calculadora.getCustoDocumentacaoUipath()));
    }

    public double implementacaoSelenium(CalculadoraComplex calculadora) {
        return calculadora.getCustoImplementacaoSelenium() + calculadora.getCustoInfraSelenium() + calculadora.getCustoTreinamentoSelenium() + calculadora.getCustoDocumentacaoSelenium();
    }

    public double implementacaoUipath(CalculadoraComplex calculadora) {
        return calculadora.getCustoImplementacaoUipath() + calculadora.getCustoInfraUipath() + calculadora.getCustoTreinamentoUipath() + calculadora.getCustoDocumentacaoUipath();
    }

}
