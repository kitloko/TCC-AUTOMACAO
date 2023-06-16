package br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Complex;

import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Complex.graficos.Grafico;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Selenium;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Uipath;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;


@Getter
@Setter
@NoArgsConstructor
public class CalculadoraComplexDto {

    private Processo processo;
    private Selenium selenium;
    private Uipath uipath;
    private Servicos servicos;
    private Grafico grafico;


    public CalculadoraComplexDto(Processo processo, Selenium selenium, Uipath uipath, Servicos servicos, Grafico grafico) {
        this.processo = processo;
        this.selenium = selenium;
        this.uipath = uipath;
        this.servicos = servicos;
        this.grafico = grafico;
    }
}

