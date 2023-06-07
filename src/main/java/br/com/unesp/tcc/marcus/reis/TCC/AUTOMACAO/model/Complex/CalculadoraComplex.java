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

    private double custoDesenvolvimento = 0.0;
    private String tempoDesenvolvimento;
    private double custoSoftware = 0.0;

    private double custoImplementacao = 0.0;
    private double custoInfra = 0.0;
    private double custoTreinamento = 0.0;
    private double custoDocumentacao = 0.0;

    private double custoSuporteInput = 0.0;
    private String tempoContratadoSuporte;

    private double custoApiServico = 0.0;
    private double custoCaptchaServico = 0.0;
    private double custoCloudServico = 0.0;
    private double custoPlataformaServico = 0.0;
}
