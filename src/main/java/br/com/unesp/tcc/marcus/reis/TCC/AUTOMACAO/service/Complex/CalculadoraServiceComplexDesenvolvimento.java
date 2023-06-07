package br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.service.Complex;

import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Automation;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Complex.CalculadoraComplex;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;

@Service
public class CalculadoraServiceComplexDesenvolvimento {

    private final NumberFormat formatter = NumberFormat.getCurrencyInstance();

    public void calculadoraBasicaAutomation(CalculadoraComplex calculadora) {
        calculadora.getCustoDesenvolvimento();
        calculadora.getTempoDesenvolvimento();
        calculadora.getCustoSoftware();

        Double custoDesenvolvimento = calculadora.getCustoDesenvolvimento();
        Double custoSoftware = calculadora.getCustoSoftware();

        String[] split = calculadora.getTempoDesenvolvimento().split("\\.");
        String hora = split[0];
        String minuto = split[1];
        String tempo = String.valueOf(Integer.parseInt(hora) + 60) + Integer.parseInt(minuto);

        Double custoProcessoMinuto = (Double.parseDouble(tempo)) / calculadora.getCustoDesenvolvimento();
        Double custoProcessoHora = custoProcessoMinuto / 60;

        Double custoTotalProcesso = custoDesenvolvimento + custoSoftware;
    }

}
