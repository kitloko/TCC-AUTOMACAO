package br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.service;

import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Calculadora;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.CalculadoraDto;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Selenium;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Uipath;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;

@Service
public class CalculadoraService {

    private final NumberFormat formatter = NumberFormat.getCurrencyInstance();
    private final Selenium selenium = new Selenium();
    private final Uipath uipath = new Uipath();

    public CalculadoraDto calculadoraBasica(Calculadora calculadora) {

        CalculadoraDto calculadoraDto = new CalculadoraDto();
        calculadoraDto.setSelenium(new CalculadoraServiceSelenium().calculadoraBasicaSelenium(calculadora));
        calculadoraDto.setUipath(new CalculadoraServiceUipath().calculadoraBasicaUipath(calculadora));
        calculadoraDto.setAutomation(new CalculadoraServiceAA().calculadoraBasicaAutomation(calculadora));
        calculadoraDto.setPower(new CalculadoraServicePower().calculadoraBasicaPower(calculadora));
        converteCalculadora(calculadoraDto, calculadora);
        return calculadoraDto;
    }

    private void converteCalculadora(CalculadoraDto calculadoraDto, Calculadora calculadora) {
        calculadoraDto.setCustoProcesso(formatter.format(calculadora.getCustoProcesso()));
        calculadoraDto.setGraficoProcesso(calculadora.getCustoProcesso());

        calculadoraDto.setCustoDesenvolvimento(formatter.format(calculadora.getCustoDesenvolvimento()));
        calculadoraDto.setCustoImplementacao(formatter.format(calculadora.getCustoImplementacao()));
        calculadoraDto.setCustoManutencao(formatter.format(calculadora.getCustoManutencao()));
        calculadoraDto.setCustoServicos(formatter.format(calculadora.getCustoServicos()));
    }
}
