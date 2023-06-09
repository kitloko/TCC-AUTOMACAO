package br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Complex;

import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Automation;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Power;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Selenium;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Uipath;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CalculadoraComplexDto {

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


    public CalculadoraComplexDto(Selenium selenium, Uipath uipath) {
        this.selenium = selenium;
        this.uipath = uipath;
    }
}

