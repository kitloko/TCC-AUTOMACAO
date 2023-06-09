package br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Uipath {

    private String nomePlataforma = "UiPath";
    private double custoMensalidade = 2359.08;
    private String mensalidade;

    private String desenvolvendo;
    private String implementacao;

    private String custoDesenvolvendo;
    private String tempoDesenvolvendo;
    private String custoSoftwareDesenvolvendo;
    private String totalCustoDesenvolvendo;

    private String custoImplementacao;
    private String custoInfra;
    private String custoTreinamento;
    private String custoDocumentacao;
    private String totalCustoImplementacao;

    private String custoSuporte;
    private String tempoContratadoSup;

    private String producao;
    private String reducao;
    private String roi;

    private double graficoDesenvolvendo;
    private double graficoImplementacao;
    private double graficoSuporte;
    private double graficoProducao;
}
