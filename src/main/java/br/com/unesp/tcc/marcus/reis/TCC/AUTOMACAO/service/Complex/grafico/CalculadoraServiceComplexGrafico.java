package br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.service.Complex.grafico;

import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Complex.CalculadoraComplex;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Complex.CalculadoraComplexDto;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Complex.graficos.GraficoCustosProjeto;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Complex.graficos.GraficoCustosProjetoTempo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CalculadoraServiceComplexGrafico {

    public void calculadoraComplexGrafico(CalculadoraComplexDto calculadoraComplexDto) {
        calculadoraComplexDto.getGrafico().setCustosProjeto(calculadoraComplexCusto(calculadoraComplexDto));
        calculadoraComplexDto.getGrafico().setTempo(calculadoraComplexTempo(calculadoraComplexDto));
    }

    public ArrayList<GraficoCustosProjeto> calculadoraComplexCusto(CalculadoraComplexDto calculadoraComplexDto) {

        ArrayList<GraficoCustosProjeto> myLibrary = new ArrayList<GraficoCustosProjeto>();

        myLibrary.add(new GraficoCustosProjeto(
                "Desenvolvimento",
                calculadoraComplexDto.getSelenium().getGraficoDesenvolvendo(),
                calculadoraComplexDto.getUipath().getGraficoDesenvolvendo(),
                calculadoraComplexDto.getProcesso().getGraficoProcesso()
        ));

        myLibrary.add(new GraficoCustosProjeto(
                "Implementação",
                calculadoraComplexDto.getSelenium().getGraficoImplementacao(),
                calculadoraComplexDto.getUipath().getGraficoImplementacao(),
                calculadoraComplexDto.getProcesso().getGraficoProcesso()
        ));

        myLibrary.add(new GraficoCustosProjeto(
                "Produção",
                calculadoraComplexDto.getSelenium().getGraficoProducao(),
                calculadoraComplexDto.getUipath().getGraficoProducao(),
                calculadoraComplexDto.getProcesso().getGraficoProcesso()
        ));

        return myLibrary;
    }

    public ArrayList<GraficoCustosProjetoTempo> calculadoraComplexTempo(CalculadoraComplexDto calculadoraComplexDto) {

        ArrayList<GraficoCustosProjetoTempo> myLibrary = new ArrayList<GraficoCustosProjetoTempo>();

        int tempoSeleniumDev = Integer.parseInt(calculadoraComplexDto.getSelenium().getTempoDesenvolvendo().split(" ")[0]);
        int tempoUipathDev = Integer.parseInt(calculadoraComplexDto.getUipath().getTempoDesenvolvendo().split(" ")[0]);

        double valorSelenium = calculadoraComplexDto.getSelenium().getGraficoDesenvolvendo();
        double valorUipath = calculadoraComplexDto.getUipath().getGraficoDesenvolvendo();

        if (tempoSeleniumDev <= 30 && tempoUipathDev <= 30) {

            int count = 1;

            for (int i = 0; i < 30; i++) {

                if (i > tempoSeleniumDev)
                    valorSelenium = calculadoraComplexDto.getSelenium().getGraficoImplementacao();

                if (i > (tempoSeleniumDev + 1))
                    valorSelenium = calculadoraComplexDto.getSelenium().getGraficoProducao();

                if (i > tempoUipathDev)
                    valorUipath = calculadoraComplexDto.getUipath().getGraficoImplementacao();

                if (i > (tempoUipathDev + 1))
                    valorUipath = calculadoraComplexDto.getUipath().getGraficoProducao();

                myLibrary.add(new GraficoCustosProjetoTempo(
                        String.valueOf(count++),
                        valorSelenium,
                        valorUipath,
                        calculadoraComplexDto.getProcesso().getGraficoProcesso()
                ));
            }
        } else {
            int count = 0;
            String[] meses = {"Jan", "Fev", "Mar", "Abr", "Mai","Jun","Jul","Ago","Set","Out","Nov", "Dez"};
            tempoSeleniumDev = tempoSeleniumDev / 30;
            tempoUipathDev = tempoUipathDev / 30;
            for (int i = 0; i < 12; i++) {

                if (i > tempoSeleniumDev)
                    valorSelenium = calculadoraComplexDto.getSelenium().getGraficoImplementacao();

                if (i > (tempoSeleniumDev + 1))
                    valorSelenium = calculadoraComplexDto.getSelenium().getGraficoProducao();

                if (i > tempoUipathDev)
                    valorUipath = calculadoraComplexDto.getUipath().getGraficoImplementacao();

                if (i > (tempoUipathDev + 1))
                    valorUipath = calculadoraComplexDto.getUipath().getGraficoProducao();

                myLibrary.add(new GraficoCustosProjetoTempo(
                        meses[count++],
                        valorSelenium,
                        valorUipath,
                        calculadoraComplexDto.getProcesso().getGraficoProcesso()
                ));
            }
        }

        return myLibrary;
    }
}