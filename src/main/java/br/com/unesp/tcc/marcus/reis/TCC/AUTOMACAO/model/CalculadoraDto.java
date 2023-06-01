package br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CalculadoraDto {

    private String custoProcesso;
    private String custoDesenvolvimento;
    private String custoImplementacao;
    private String custoManutencao;
    private String custoServicos;

    private Selenium selenium;
    private Uipath uipath;
    private Automation automation;
    private Power power;

    private double graficoProcesso;


}

