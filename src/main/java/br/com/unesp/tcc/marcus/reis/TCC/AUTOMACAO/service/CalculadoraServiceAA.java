package br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.service;

import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Calculadora;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.CalculadoraDto;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Selenium;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Automation;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;

@Service
public class CalculadoraServiceAA {

    private final NumberFormat formatter = NumberFormat.getCurrencyInstance();

    public Automation calculadoraBasicaAutomation(Calculadora calculadora) {

        Automation automation = new Automation();
        calculaDesenvolvimento(automation, calculadora);
        calculaimplementacao(automation, calculadora);
        calculaProducao(automation, calculadora);
        plataformas(automation, calculadora);
        return automation;
    }


    private void calculaDesenvolvimento(Automation automation, Calculadora calculadora) {
        if(calculadora.isCustoProcessoProd()) {
            automation.setDesenvolvendo(formatter.format(calculadora.getCustoProcesso() + calculadora.getCustoDesenvolvimento() + calculadora.getCustoServicos() + automation.getCustoMensalidade()));
            automation.setGraficoDesenvolvendo(calculadora.getCustoProcesso() + calculadora.getCustoDesenvolvimento() + calculadora.getCustoServicos() + automation.getCustoMensalidade());
        }
        else {
            automation.setDesenvolvendo(formatter.format(calculadora.getCustoDesenvolvimento() + calculadora.getCustoServicos() + automation.getCustoMensalidade()));
            automation.setGraficoDesenvolvendo(calculadora.getCustoDesenvolvimento() + calculadora.getCustoServicos() + automation.getCustoMensalidade());
        }

    }

    private void calculaimplementacao(Automation automation, Calculadora calculadora) {
        if(calculadora.isCustoProcessoProd()){
            automation.setImplementacao(formatter.format(calculadora.getCustoProcesso() + calculadora.getCustoImplementacao() + calculadora.getCustoServicos() + automation.getCustoMensalidade()));
            automation.setGraficoImplementacao(calculadora.getCustoProcesso() + calculadora.getCustoImplementacao() + calculadora.getCustoServicos() + automation.getCustoMensalidade());
        }
        else{
            automation.setImplementacao(formatter.format(calculadora.getCustoImplementacao() + calculadora.getCustoServicos() + automation.getCustoMensalidade()));
            automation.setGraficoImplementacao(calculadora.getCustoImplementacao() + calculadora.getCustoServicos() + automation.getCustoMensalidade());
        }
    }

    private void calculaProducao(Automation automation, Calculadora calculadora) {
        automation.setProducao(formatter.format(calculadora.getCustoManutencao() + calculadora.getCustoServicos() + automation.getCustoMensalidade()));
        automation.setGraficoProducao(calculadora.getCustoManutencao() + calculadora.getCustoServicos() + automation.getCustoMensalidade());
    }

    private void plataformas(Automation automation, Calculadora calculadora) {
        insereplataforma(automation);
        reducaoCusto(automation, calculadora);
        roi(automation, calculadora);
    }

    private void insereplataforma(Automation automation) {
        automation.setNomePlataforma(automation.getNomePlataforma());
        automation.setMensalidade(formatter.format(automation.getCustoMensalidade()));
    }

    private void reducaoCusto(Automation automation, Calculadora calculadora) {
        automation.setReducao(formatter.format(calculadora.getCustoProcesso() - calculadora.getCustoDesenvolvimento() - calculadora.getCustoImplementacao() - calculadora.getCustoManutencao() - calculadora.getCustoServicos() - automation.getCustoMensalidade()));
    }

    private void roi(Automation automation, Calculadora calculadora) {
        double reducao = calculadora.getCustoProcesso() - calculadora.getCustoDesenvolvimento() - calculadora.getCustoImplementacao() - calculadora.getCustoManutencao() - calculadora.getCustoServicos();
        double custo = calculadora.getCustoDesenvolvimento() + calculadora.getCustoImplementacao() + calculadora.getCustoManutencao() + calculadora.getCustoServicos();

        automation.setRoi(String.format("%.2f%%",
                (((reducao - automation.getCustoMensalidade())
                        - custo) / custo) * 100));
    }

}
