package br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.service.Complex;

import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Complex.CalculadoraComplex;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Complex.CalculadoraComplexDto;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;

@Service
public class CalculadoraServiceComplexServicos {

    private final NumberFormat formatter = NumberFormat.getCurrencyInstance();

    public void calculadoraComplexServicos(CalculadoraComplexDto calculadoraComplexDto, CalculadoraComplex calculadora) {

        calculadoraComplexDto.getServicos().setCustoApiServico(formatter.format(calculadora.getCustoApiServico()));
        calculadoraComplexDto.getServicos().setCustoCloudServico(formatter.format(calculadora.getCustoCloudServico()));
        calculadoraComplexDto.getServicos().setCustoCaptchaServico(formatter.format(calculadora.getCustoCaptchaServico()));
        calculadoraComplexDto.getServicos().setCustoPlataformaServico(formatter.format(calculadora.getCustoPlataformaServico()));


        calculadoraComplexDto.getServicos().setCustoServicos(formatter.format(retornaServicos(calculadora)));
        calculadoraComplexDto.getServicos().setGraficoServicos(retornaServicos(calculadora));
    }

    public double retornaServicos(CalculadoraComplex calculadora) {
        Double api = calculadora.getCustoApiServico();
        Double clound = calculadora.getCustoCloudServico();
        Double captcha = calculadora.getCustoCaptchaServico();
        Double plataforma = calculadora.getCustoPlataformaServico();

        return api + clound + captcha + plataforma;
    }


}
