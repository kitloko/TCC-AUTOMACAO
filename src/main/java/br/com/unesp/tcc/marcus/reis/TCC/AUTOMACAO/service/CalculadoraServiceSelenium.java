package br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.service;

import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Calculadora;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Selenium;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;

@Service
public class CalculadoraServiceSelenium {
    private final NumberFormat formatter = NumberFormat.getCurrencyInstance();

    public Selenium calculadoraBasicaSelenium(Calculadora calculadora) {
        Selenium selenium = new Selenium();
        calculaDesenvolvimento(selenium, calculadora);
        calculaimplementacao(selenium, calculadora);
        calculaProducao(selenium, calculadora);
        plataformas(selenium, calculadora);
        return selenium;
    }


    private void calculaDesenvolvimento(Selenium selenium, Calculadora calculadora) {
        if (calculadora.isCustoProcessoProd()) {
            selenium.setDesenvolvendo(formatter.format(calculadora.getCustoProcesso() + calculadora.getCustoDesenvolvimento() + calculadora.getCustoServicos()));
            selenium.setGraficoDesenvolvendo(calculadora.getCustoProcesso() + calculadora.getCustoDesenvolvimento() + calculadora.getCustoServicos());
        } else {
            selenium.setDesenvolvendo(formatter.format(calculadora.getCustoDesenvolvimento() + calculadora.getCustoServicos()));
            selenium.setGraficoDesenvolvendo(calculadora.getCustoDesenvolvimento() + calculadora.getCustoServicos());
        }

    }

    private void calculaimplementacao(Selenium selenium, Calculadora calculadora) {
        if (calculadora.isCustoProcessoProd()) {
            selenium.setImplementacao(formatter.format(calculadora.getCustoProcesso() + calculadora.getCustoImplementacao() + calculadora.getCustoServicos()));
            selenium.setGraficoImplementacao(calculadora.getCustoProcesso() + calculadora.getCustoImplementacao() + calculadora.getCustoServicos());
        } else {
            selenium.setImplementacao(formatter.format(calculadora.getCustoImplementacao() + calculadora.getCustoServicos()));
            selenium.setGraficoImplementacao(calculadora.getCustoImplementacao() + calculadora.getCustoServicos());
        }
    }

    private void calculaProducao(Selenium selenium, Calculadora calculadora) {
        selenium.setProducao(formatter.format(calculadora.getCustoManutencao() + calculadora.getCustoServicos()));
        selenium.setGraficoProducao(calculadora.getCustoManutencao() + calculadora.getCustoServicos());
    }

    private void plataformas(Selenium selenium, Calculadora calculadora) {
        insereplataforma(selenium);
        reducaoCusto(selenium, calculadora);
        roi(selenium, calculadora);
    }

    private void insereplataforma(Selenium selenium) {
        selenium.setNomePlataforma(selenium.getNomePlataforma());
        selenium.setMensalidade(formatter.format(selenium.getCustoMensalidade()));
    }

    private void reducaoCusto(Selenium selenium, Calculadora calculadora) {
        selenium.setReducao(formatter.format(calculadora.getCustoProcesso() - calculadora.getCustoDesenvolvimento() - calculadora.getCustoImplementacao() - calculadora.getCustoManutencao() - calculadora.getCustoServicos() - selenium.getCustoMensalidade()));
    }

    private void roi(Selenium selenium, Calculadora calculadora) {
        double reducao = calculadora.getCustoProcesso() - calculadora.getCustoDesenvolvimento() - calculadora.getCustoImplementacao() - calculadora.getCustoManutencao() - calculadora.getCustoServicos();
        double custo = calculadora.getCustoDesenvolvimento() + calculadora.getCustoImplementacao() + calculadora.getCustoManutencao() + calculadora.getCustoServicos();

        selenium.setRoi(String.format("%.2f%%",
                ((reducao - custo) / custo) * 100));

    }

}
