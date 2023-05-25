package br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Calculadora {

    private double custoProcesso = 0.0;
    private boolean custoProcessoProd;
    private double custoDesenvolvimento = 0.0;
    private double custoImplementacao = 0.0;
    private double custoManutencao = 0.0;
    private double custoServicos = 0.0;

    private int plataformaUm = 0;
    private int plataformaDois = 0;

    private int custoPlataformaUm = 0;
    private int custoPlataformaDois = 0;



}
