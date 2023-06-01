package br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.service;

import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Calculadora;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.CalculadoraDto;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Selenium;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Power;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;

@Service
public class CalculadoraServicePower {

    private final NumberFormat formatter = NumberFormat.getCurrencyInstance();

    public Power calculadoraBasicaPower(Calculadora calculadora) {

        Power power = new Power();
        calculaDesenvolvimento(power, calculadora);
        calculaimplementacao(power, calculadora);
        calculaProducao(power, calculadora);
        plataformas(power, calculadora);
        return power;
    }


    private void calculaDesenvolvimento(Power power, Calculadora calculadora) {
        if(calculadora.isCustoProcessoProd()) {
            power.setDesenvolvendo(formatter.format(calculadora.getCustoProcesso() + calculadora.getCustoDesenvolvimento() + calculadora.getCustoServicos() + power.getCustoMensalidade()));
            power.setGraficoDesenvolvendo(calculadora.getCustoProcesso() + calculadora.getCustoDesenvolvimento() + calculadora.getCustoServicos() + power.getCustoMensalidade());
        }
        else {
            power.setDesenvolvendo(formatter.format( calculadora.getCustoDesenvolvimento() + calculadora.getCustoServicos() + power.getCustoMensalidade()));
            power.setGraficoDesenvolvendo(calculadora.getCustoDesenvolvimento() + calculadora.getCustoServicos() + power.getCustoMensalidade());
        }

    }

    private void calculaimplementacao(Power power, Calculadora calculadora) {
        if(calculadora.isCustoProcessoProd()){
            power.setImplementacao(formatter.format(calculadora.getCustoProcesso() + calculadora.getCustoImplementacao() + calculadora.getCustoServicos() + power.getCustoMensalidade()));
            power.setGraficoImplementacao(calculadora.getCustoProcesso() + calculadora.getCustoImplementacao() + calculadora.getCustoServicos() + power.getCustoMensalidade());
        }
        else{
            power.setImplementacao(formatter.format(calculadora.getCustoImplementacao() + calculadora.getCustoServicos() + power.getCustoMensalidade()));
            power.setGraficoImplementacao(calculadora.getCustoImplementacao() + calculadora.getCustoServicos() + power.getCustoMensalidade());
        }
    }

    private void calculaProducao(Power power, Calculadora calculadora) {
        power.setProducao(formatter.format(calculadora.getCustoManutencao() + calculadora.getCustoServicos() + power.getCustoMensalidade()));
        power.setGraficoProducao(calculadora.getCustoManutencao() + calculadora.getCustoServicos() + power.getCustoMensalidade());
    }

    private void plataformas(Power power, Calculadora calculadora) {
        insereplataforma(power);
        reducaoCusto(power, calculadora);
        roi(power, calculadora);
    }

    private void insereplataforma(Power power) {
        power.setNomePlataforma(power.getNomePlataforma());
        power.setMensalidade(formatter.format(power.getCustoMensalidade()));
    }

    private void reducaoCusto(Power power, Calculadora calculadora) {
        power.setReducao(formatter.format(calculadora.getCustoProcesso() - calculadora.getCustoDesenvolvimento() - calculadora.getCustoImplementacao() - calculadora.getCustoManutencao() - calculadora.getCustoServicos() - power.getCustoMensalidade()));
    }

    private void roi(Power power, Calculadora calculadora) {
        double reducao = calculadora.getCustoProcesso() - calculadora.getCustoDesenvolvimento() - calculadora.getCustoImplementacao() - calculadora.getCustoManutencao() - calculadora.getCustoServicos();
        double custo = calculadora.getCustoDesenvolvimento() + calculadora.getCustoImplementacao() + calculadora.getCustoManutencao() + calculadora.getCustoServicos();

        power.setRoi(String.format("%.2f%%",
                (((reducao - power.getCustoMensalidade())
                        - custo) / custo) * 100));
    }

}
