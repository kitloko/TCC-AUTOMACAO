package br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.service.Complex;

import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Complex.CalculadoraComplex;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Complex.CalculadoraComplexDto;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;

@Service
public class CalculadoraServiceComplexProcesso {

    private final NumberFormat formatter = NumberFormat.getCurrencyInstance();

    public void calculadoraComplexProcesso(CalculadoraComplexDto calculadoraComplexDto, CalculadoraComplex calculadora) {
        Double custoProcesso = calculadora.getCustoProcesso();
        Double custoColabProcesso = calculadora.getCustoColabProcesso();
        Double despesasProcesso = calculadora.getDespesasProcesso();
        String tempoProcesso = calculadora.getTempoProcesso();

        calculadoraComplexDto.getProcesso().setCustoProcesso(formatter.format(custoProcesso));
        calculadoraComplexDto.getProcesso().setCustoColabProcesso(formatter.format(custoColabProcesso));
        calculadoraComplexDto.getProcesso().setDespesasProcesso(formatter.format(despesasProcesso));
        calculadoraComplexDto.getProcesso().setTempoProcesso((Integer.parseInt(tempoProcesso) / 8) + " dias");

        Double custoTotalProcesso = custoProcesso + custoColabProcesso + despesasProcesso;
        calculadoraComplexDto.getProcesso().setGraficoProcesso(custoTotalProcesso);

    }
}