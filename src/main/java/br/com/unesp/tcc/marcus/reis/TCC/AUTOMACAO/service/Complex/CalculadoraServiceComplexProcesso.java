package br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.service.Complex;

import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Automation;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Complex.CalculadoraComplex;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;

@Service
public class CalculadoraServiceComplexProcesso {

    private final NumberFormat formatter = NumberFormat.getCurrencyInstance();

    public void calculadoraComplexProcesso(CalculadoraComplex calculadora) {
        Double custoProcesso = calculadora.getCustoProcesso();
        Double custoColabProcesso = calculadora.getCustoColabProcesso();
        Double despesasProcesso = calculadora.getDespesasProcesso();

        String[] split = calculadora.getTempoProcesso().split("\\.");
        String hora = split[0];
        String minuto = split[1];
        String tempo = String.valueOf(Integer.parseInt(hora) + 60) + Integer.parseInt(minuto);

        Double custoProcessoMinuto = (Double.parseDouble(tempo)) / calculadora.getCustoProcesso();
        Double custoProcessoHora = custoProcessoMinuto / 60;

        Double custoTotalProcesso = custoProcesso + custoColabProcesso + despesasProcesso;
    }
}