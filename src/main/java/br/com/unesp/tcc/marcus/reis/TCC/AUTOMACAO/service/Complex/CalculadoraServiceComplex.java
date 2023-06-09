package br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.service.Complex;

import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Complex.CalculadoraComplex;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Complex.CalculadoraComplexDto;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Selenium;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Uipath;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.service.CalculadoraServiceAA;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.service.CalculadoraServicePower;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.service.CalculadoraServiceSelenium;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.service.CalculadoraServiceUipath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;

@Service
public class CalculadoraServiceComplex {

    private final NumberFormat formatter = NumberFormat.getCurrencyInstance();

    @Autowired
    private CalculadoraServiceComplexProcesso calculadoraServiceComplexProcesso;

    @Autowired
    private CalculadoraServiceComplexDesenvolvimento calculadoraServiceComplexDesenvolvimento;

    @Autowired
    private CalculadoraServiceComplexImplementacao calculadoraServiceComplexImplementacao;

    @Autowired
    private CalculadoraServiceComplexServicos calculadoraServiceComplexServicos;

    @Autowired
    private CalculadoraServiceComplexSuporte calculadoraServiceComplexSuporte;

    public CalculadoraComplexDto calculadoraComplex(CalculadoraComplex calculadoraComplex) {

        CalculadoraComplexDto calculadoraComplexDto = new CalculadoraComplexDto(new Selenium(), new Uipath());
        calculadoraServiceComplexProcesso.calculadoraComplexProcesso(calculadoraComplex);
        calculadoraServiceComplexDesenvolvimento.calculadoraComplexDesenvolvimento(calculadoraComplexDto, calculadoraComplex);
        calculadoraServiceComplexImplementacao.calculadoraComplexImplementacao(calculadoraComplexDto, calculadoraComplex);
        calculadoraServiceComplexServicos.calculadoraComplexSuporte(calculadoraComplexDto, calculadoraComplex);
        return calculadoraComplexDto;

    }
}
