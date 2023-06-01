package br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.service;

import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Calculadora;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Uipath;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;

@Service
public class CalculadoraServiceUipath {

    private final NumberFormat formatter = NumberFormat.getCurrencyInstance();

    public Uipath calculadoraBasicaUipath(Calculadora calculadora) {

        Uipath uipath = new Uipath();
        calculaDesenvolvimento(uipath, calculadora);
        calculaimplementacao(uipath, calculadora);
        calculaProducao(uipath, calculadora);
        plataformas(uipath, calculadora);
        return uipath;
    }


    private void calculaDesenvolvimento(Uipath uipath, Calculadora calculadora) {
        if(calculadora.isCustoProcessoProd()) {
            uipath.setDesenvolvendo(formatter.format(calculadora.getCustoProcesso() + calculadora.getCustoDesenvolvimento() + calculadora.getCustoServicos() + uipath.getCustoMensalidade()));
            uipath.setGraficoDesenvolvendo(calculadora.getCustoProcesso() + calculadora.getCustoDesenvolvimento() + calculadora.getCustoServicos() + uipath.getCustoMensalidade());
        }
        else {
            uipath.setDesenvolvendo(formatter.format(calculadora.getCustoDesenvolvimento() + calculadora.getCustoServicos() + uipath.getCustoMensalidade()));
            uipath.setGraficoDesenvolvendo(calculadora.getCustoDesenvolvimento() + calculadora.getCustoServicos() + uipath.getCustoMensalidade());
        }

    }

    private void calculaimplementacao(Uipath uipath, Calculadora calculadora) {
        if(calculadora.isCustoProcessoProd()){
            uipath.setImplementacao(formatter.format(calculadora.getCustoProcesso() + calculadora.getCustoImplementacao() + calculadora.getCustoServicos() + uipath.getCustoMensalidade()));
            uipath.setGraficoImplementacao(calculadora.getCustoProcesso() + calculadora.getCustoImplementacao() + calculadora.getCustoServicos() + uipath.getCustoMensalidade());
        }
        else{
            uipath.setImplementacao(formatter.format(calculadora.getCustoImplementacao() + calculadora.getCustoServicos() + uipath.getCustoMensalidade()));
            uipath.setGraficoImplementacao(calculadora.getCustoImplementacao() + calculadora.getCustoServicos() + uipath.getCustoMensalidade());
        }
    }

    private void calculaProducao(Uipath uipath, Calculadora calculadora) {
        uipath.setProducao(formatter.format(calculadora.getCustoManutencao() + calculadora.getCustoServicos() + uipath.getCustoMensalidade()));
        uipath.setGraficoProducao(calculadora.getCustoManutencao() + calculadora.getCustoServicos() + uipath.getCustoMensalidade());
    }

    private void plataformas(Uipath uipath, Calculadora calculadora) {
        insereplataforma(uipath);
        reducaoCusto(uipath, calculadora);
        roi(uipath, calculadora);
    }

    private void insereplataforma(Uipath uipath) {
        uipath.setNomePlataforma(uipath.getNomePlataforma());
        uipath.setMensalidade(formatter.format(uipath.getCustoMensalidade()));
    }

    private void reducaoCusto(Uipath uipath, Calculadora calculadora) {
        uipath.setReducao(formatter.format(calculadora.getCustoProcesso() - calculadora.getCustoDesenvolvimento() - calculadora.getCustoImplementacao() - calculadora.getCustoManutencao() - calculadora.getCustoServicos() - uipath.getCustoMensalidade()));
    }

    private void roi(Uipath uipath, Calculadora calculadora) {
        double reducao = calculadora.getCustoProcesso() - calculadora.getCustoDesenvolvimento() - calculadora.getCustoImplementacao() - calculadora.getCustoManutencao() - calculadora.getCustoServicos();
        double custo = calculadora.getCustoDesenvolvimento() + calculadora.getCustoImplementacao() + calculadora.getCustoManutencao() + calculadora.getCustoServicos();

        uipath.setRoi(String.format("%.2f%%",
                (((reducao - uipath.getCustoMensalidade())
                        - custo) / custo) * 100));
    }
}
