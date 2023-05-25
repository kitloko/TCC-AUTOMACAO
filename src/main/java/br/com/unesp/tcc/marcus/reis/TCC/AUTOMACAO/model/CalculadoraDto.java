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
    
    private String desenvolvendoUm;
    private String implementacaoUm;
    private String producaoUm;
    private String reducaoUm;
    private String roiUm;

    private String desenvolvendoDois;
    private String implementacaoDois;
    private String producaoDois;
    private String reducaoDois;
    private String roiDois;

    private String nomeplataformaUm;
    private String nomeplataformaDois;
    private String plataformaUm;
    private String plataformaDois;

    private double graficoProcesso;

    private double graficoDesenvolvendoUm;
    private double graficoImplementacaoUm;
    private double graficoProducaoUm;

    private double graficoDesenvolvendoDois;
    private double graficoImplementacaoDois;
    private double graficoProducaoDois;



}

