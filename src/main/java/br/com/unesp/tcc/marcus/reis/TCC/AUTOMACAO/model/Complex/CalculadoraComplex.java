package br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Complex;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CalculadoraComplex {

    private double custoProcesso = 0.0;
    private boolean custoProcessoProd;
    private String tempoProcesso;
    private double custoColabProcesso = 0.0;
    private double despesasProcesso = 0.0;

    private double custoDesenvolvimentoSelenium = 0.0;
    private String tempoDesenvolvimentoSelenium;
    private double custoSoftwareSelenium = 0.0;

    private double custoImplementacaoSelenium = 0.0;
    private double custoInfraSelenium = 0.0;
    private double custoTreinamentoSelenium = 0.0;
    private double custoDocumentacaoSelenium = 0.0;

    private double custoSuporteSelenium = 0.0;
    private String tempoContratadoSuporteSelenium;



    private double custoDesenvolvimentoUipath = 0.0;
    private String tempoDesenvolvimentoUipath;
    private double custoSoftwareUipath = 0.0;

    private double custoImplementacaoUipath = 0.0;
    private double custoInfraUipath = 0.0;
    private double custoTreinamentoUipath = 0.0;
    private double custoDocumentacaoUipath = 0.0;

    private double custoSuporteInputUipath = 0.0;
    private String tempoContratadoSuporteUipath;



    private double custoApiServico = 0.0;
    private double custoCaptchaServico = 0.0;
    private double custoCloudServico = 0.0;
    private double custoPlataformaServico = 0.0;
}
