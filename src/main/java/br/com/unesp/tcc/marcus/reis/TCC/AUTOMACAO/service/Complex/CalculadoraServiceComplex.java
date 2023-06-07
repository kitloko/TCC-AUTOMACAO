package br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.service.Complex;

import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Complex.CalculadoraComplex;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Complex.CalculadoraComplexDto;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.service.CalculadoraServiceAA;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.service.CalculadoraServicePower;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.service.CalculadoraServiceSelenium;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.service.CalculadoraServiceUipath;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;

@Service
public class CalculadoraServiceComplex {

    private final NumberFormat formatter = NumberFormat.getCurrencyInstance();

    public CalculadoraComplexDto calculadoraComplex(CalculadoraComplex calculadoraComplex) {

        CalculadoraComplexDto calculadoraComplexDto = new CalculadoraComplexDto();
        converteCalculadora(calculadoraComplexDto, calculadoraComplex);
        return calculadoraComplexDto;

    }

    private void converteCalculadora(CalculadoraComplexDto calculadoraComplexDto, CalculadoraComplex calculadoraComplexa) {
        calculadoraComplexDto.setCustoProcesso(formatter.format(calculadoraComplexa.getCustoProcesso()));
        calculadoraComplexDto.setGraficoProcesso(calculadoraComplexa.getCustoProcesso());
        calculadoraComplexDto.setCustoDesenvolvimento(formatter.format(calculadoraComplexa.getCustoDesenvolvimento()));
        calculadoraComplexDto.setCustoImplementacao(formatter.format(calculadoraComplexa.getCustoImplementacao()));
    }
}
