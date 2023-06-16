package br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.service.Complex;

import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Complex.CalculadoraComplex;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Complex.CalculadoraComplexDto;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Complex.Processo;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Complex.Servicos;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Complex.graficos.Grafico;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Selenium;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Uipath;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.service.CalculadoraServiceAA;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.service.CalculadoraServicePower;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.service.CalculadoraServiceSelenium;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.service.CalculadoraServiceUipath;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.service.Complex.grafico.CalculadoraServiceComplexGrafico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.ArrayList;

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

    @Autowired
    private CalculadoraServiceComplexGrafico grafico;

    public CalculadoraComplexDto calculadoraComplex(CalculadoraComplex calculadoraComplex) {

        CalculadoraComplexDto calculadoraComplexDto = new CalculadoraComplexDto(new Processo(), new Selenium(), new Uipath(), new Servicos(), new Grafico());
        calculadoraServiceComplexProcesso.calculadoraComplexProcesso(calculadoraComplexDto, calculadoraComplex);
        calculadoraServiceComplexDesenvolvimento.calculadoraComplexDesenvolvimento(calculadoraComplexDto, calculadoraComplex);
        calculadoraServiceComplexImplementacao.calculadoraComplexImplementacao(calculadoraComplexDto, calculadoraComplex);
        calculadoraServiceComplexServicos.calculadoraComplexServicos(calculadoraComplexDto, calculadoraComplex);
        calculadoraServiceComplexSuporte.calculadoraComplexSuporte(calculadoraComplexDto, calculadoraComplex);
        producao(calculadoraComplexDto, calculadoraComplex);
        reducaoSelenium(calculadoraComplexDto, calculadoraComplex);
        reducaoUipath(calculadoraComplexDto, calculadoraComplex);
        grafico.calculadoraComplexGrafico(calculadoraComplexDto);
        return calculadoraComplexDto;

    }

    private void producao(CalculadoraComplexDto calculadoraComplexDto, CalculadoraComplex calculadora) {
        Double producaoSelenium = calculadoraServiceComplexServicos.retornaServicos(calculadora) + calculadoraServiceComplexSuporte.retornaSuporteSelenium(calculadora);
        Double producaoUipath = calculadoraServiceComplexServicos.retornaServicos(calculadora) + calculadoraServiceComplexSuporte.retornaSuporteUipath(calculadora) + calculadoraComplexDto.getUipath().getCustoMensalidade();

        calculadoraComplexDto.getSelenium().setProducao(formatter.format(producaoSelenium));
        calculadoraComplexDto.getSelenium().setGraficoProducao(producaoSelenium);
        calculadoraComplexDto.getSelenium().setMensalidade(formatter.format(0));

        calculadoraComplexDto.getUipath().setProducao(formatter.format(producaoUipath));
        calculadoraComplexDto.getUipath().setGraficoProducao(producaoUipath);
        calculadoraComplexDto.getUipath().setMensalidade(formatter.format(calculadoraComplexDto.getUipath().getCustoMensalidade()));
    }

    private void reducaoSelenium(CalculadoraComplexDto calculadoraComplexDto, CalculadoraComplex calculadora) {
        double desenvolvimentoSelenium = calculadoraServiceComplexDesenvolvimento.desenvolvimentoSelenium(calculadora);
        double impementacaoSelenium = calculadoraServiceComplexImplementacao.implementacaoSelenium(calculadora);
        double suporteSelenium = calculadoraServiceComplexSuporte.retornaSuporteSelenium(calculadora);
        double servicos = calculadoraServiceComplexServicos.retornaServicos(calculadora);

        int tempoSeleniumDev = Integer.parseInt(calculadoraComplexDto.getSelenium().getTempoDesenvolvendo().split(" ")[0]);
        tempoSeleniumDev = tempoSeleniumDev / 30;

        double custo = desenvolvimentoSelenium + impementacaoSelenium + suporteSelenium + servicos;
        double processo = calculadora.getCustoProcesso();
        double reducao = calculadora.getCustoProcesso() - custo;

        if (tempoSeleniumDev < 1) {

            calculadoraComplexDto.getSelenium().setRoi(String.format("%.2f%%",
                    ((reducao - custo) / custo) * 100));
        } else {

            for (int i = 0; i < tempoSeleniumDev; i++) {
                custo = custo + desenvolvimentoSelenium;
                processo = processo + calculadora.getCustoProcesso();
            }

            reducao = processo - custo;


            calculadoraComplexDto.getSelenium().setRoi(String.format("%.2f%%",
                    ((reducao - custo) / custo) * 100));
        }

        calculadoraComplexDto.getSelenium().setReducao(formatter.format(reducao));
    }

    private void reducaoUipath(CalculadoraComplexDto calculadoraComplexDto, CalculadoraComplex calculadora) {
        double desenvolvimentoUipath = calculadoraServiceComplexDesenvolvimento.desenvolvimentoUipath(calculadora);
        double impementacaoUipath = calculadoraServiceComplexImplementacao.implementacaoUipath(calculadora);
        double suporteUipath = calculadoraServiceComplexSuporte.retornaSuporteUipath(calculadora);
        double servicos = calculadoraServiceComplexServicos.retornaServicos(calculadora);

        int tempoUipathDev = Integer.parseInt(calculadoraComplexDto.getUipath().getTempoDesenvolvendo().split(" ")[0]);
        tempoUipathDev = tempoUipathDev / 30;

        double custo = desenvolvimentoUipath + impementacaoUipath + suporteUipath + servicos + calculadoraComplexDto.getUipath().getCustoMensalidade();
        double processo = calculadora.getCustoProcesso();
        double reducao = calculadora.getCustoProcesso() - custo;

        if (tempoUipathDev < 1) {

            calculadoraComplexDto.getUipath().setRoi(String.format("%.2f%%",
                    ((reducao - custo) / custo) * 100));
        } else {

            for (int i = 0; i < tempoUipathDev; i++) {
                custo = custo + desenvolvimentoUipath;
                processo = processo + calculadora.getCustoProcesso();
            }

            reducao = processo - custo;


            calculadoraComplexDto.getUipath().setRoi(String.format("%.2f%%",
                    ((reducao - custo) / custo) * 100));
        }

        calculadoraComplexDto.getUipath().setReducao(formatter.format(reducao));
    }
}
