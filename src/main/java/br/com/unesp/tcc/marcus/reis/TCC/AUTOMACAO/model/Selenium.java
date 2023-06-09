package br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Selenium {

    private String nomePlataforma = "Selenium";
    private double custoMensalidade = 0.0;
    private String mensalidade;
    private String desenvolvendo;
    private String tempoDesenvolvendo;
    private String implementacao;
    private String suporte;
    private String tempoSuporte;
    private String tempoServicos;
    private String producao;
    private String reducao;
    private String roi;
    private double graficoDesenvolvendo;
    private double graficoImplementacao;
    private double graficoServicos;
    private double graficoSuporte;
    private double graficoProducao;
}
