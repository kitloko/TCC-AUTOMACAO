package br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Complex;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Processo {

    private String custoProcesso;
    private String tempoProcesso;
    private String custoColabProcesso;
    private String despesasProcesso;
    private double graficoProcesso;
}
