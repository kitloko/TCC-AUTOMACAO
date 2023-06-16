package br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Complex;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Servicos {

    private String custoServicos;
    private String custoApiServico;
    private String custoCaptchaServico;
    private String custoCloudServico;
    private String custoPlataformaServico;
    private double graficoServicos;
}
