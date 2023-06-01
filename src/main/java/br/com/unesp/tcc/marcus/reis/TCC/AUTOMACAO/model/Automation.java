package br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Automation {

    private String nomePlataforma = "Automation Anywhere";
    private double custoMensalidade = 3777.0;
    private String mensalidade;
    private String desenvolvendo;
    private String implementacao;
    private String producao;
    private String reducao;
    private String roi;
    private double graficoDesenvolvendo;
    private double graficoImplementacao;
    private double graficoProducao;
}
