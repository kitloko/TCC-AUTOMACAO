package br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CalculadoraComplex {

    private String tempoProcesso;
    private double custoProcesso = 0.0;
    private double salariosProcesso = 0.0;
    private double despesasProcesso = 0.0;
}
