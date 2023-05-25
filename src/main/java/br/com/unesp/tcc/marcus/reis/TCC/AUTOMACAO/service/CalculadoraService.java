package br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.service;

import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Calculadora;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.CalculadoraDto;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Selenium;
import br.com.unesp.tcc.marcus.reis.TCC.AUTOMACAO.model.Uipath;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;

@Service
public class CalculadoraService {

    private final NumberFormat formatter = NumberFormat.getCurrencyInstance();
    private final Selenium selenium = new Selenium();
    private final Uipath uipath = new Uipath();

    public CalculadoraDto calculadoraBasica(Calculadora calculadora) {

        CalculadoraDto calculadoraDto = new CalculadoraDto();
        calculaDesenvolvimento(calculadoraDto, calculadora);
        calculaimplementacao(calculadoraDto, calculadora);
        calculaProducao(calculadoraDto, calculadora);
        converteCalculadora(calculadoraDto, calculadora);
        plataformas(calculadoraDto, calculadora);
        return calculadoraDto;
    }


    private CalculadoraDto calculaDesenvolvimento(CalculadoraDto calculadoraDto, Calculadora calculadora) {
        if(calculadora.isCustoProcessoProd()) {
            calculadoraDto.setDesenvolvendoUm(formatter.format(calculadora.getCustoProcesso() + calculadora.getCustoDesenvolvimento() + calculadora.getCustoServicos()));
            calculadoraDto.setDesenvolvendoDois(formatter.format(calculadora.getCustoProcesso() + calculadora.getCustoDesenvolvimento() + calculadora.getCustoServicos() + uipath.getCustoMensalidade()));
            calculadoraDto.setGraficoDesenvolvendoUm(calculadora.getCustoProcesso() + calculadora.getCustoDesenvolvimento() + calculadora.getCustoServicos());
            calculadoraDto.setGraficoDesenvolvendoDois(calculadora.getCustoProcesso() + calculadora.getCustoDesenvolvimento() + calculadora.getCustoServicos() + uipath.getCustoMensalidade());
        }
        else {
            calculadoraDto.setDesenvolvendoUm(formatter.format(calculadora.getCustoDesenvolvimento() + calculadora.getCustoServicos()));
            calculadoraDto.setDesenvolvendoDois(formatter.format(calculadora.getCustoProcesso() + calculadora.getCustoDesenvolvimento() + calculadora.getCustoServicos() + uipath.getCustoMensalidade()));
            calculadoraDto.setGraficoDesenvolvendoUm(calculadora.getCustoDesenvolvimento() + calculadora.getCustoServicos());
            calculadoraDto.setGraficoDesenvolvendoDois(calculadora.getCustoDesenvolvimento() + calculadora.getCustoServicos() + uipath.getCustoMensalidade());
        }

       return calculadoraDto;
    }

    private CalculadoraDto calculaimplementacao(CalculadoraDto calculadoraDto, Calculadora calculadora) {
        if(calculadora.isCustoProcessoProd()){
            calculadoraDto.setImplementacaoUm(formatter.format(calculadora.getCustoProcesso() + calculadora.getCustoImplementacao() + calculadora.getCustoServicos()));
            calculadoraDto.setImplementacaoDois(formatter.format(calculadora.getCustoProcesso() + calculadora.getCustoImplementacao() + calculadora.getCustoServicos() + uipath.getCustoMensalidade()));
            calculadoraDto.setGraficoImplementacaoUm(calculadora.getCustoProcesso() + calculadora.getCustoImplementacao() + calculadora.getCustoServicos());
            calculadoraDto.setGraficoImplementacaoDois(calculadora.getCustoProcesso() + calculadora.getCustoImplementacao() + calculadora.getCustoServicos() + uipath.getCustoMensalidade());
        }
        else{
            calculadoraDto.setImplementacaoUm(formatter.format(calculadora.getCustoImplementacao() + calculadora.getCustoServicos()));
            calculadoraDto.setImplementacaoDois(formatter.format(calculadora.getCustoImplementacao() + calculadora.getCustoServicos() + uipath.getCustoMensalidade()));
            calculadoraDto.setGraficoImplementacaoUm(calculadora.getCustoImplementacao() + calculadora.getCustoServicos());
            calculadoraDto.setGraficoImplementacaoDois(calculadora.getCustoImplementacao() + calculadora.getCustoServicos() + uipath.getCustoMensalidade());
        }
        return calculadoraDto;
    }

    private CalculadoraDto calculaProducao(CalculadoraDto calculadoraDto, Calculadora calculadora) {
        calculadoraDto.setProducaoUm(formatter.format(calculadora.getCustoManutencao() + calculadora.getCustoServicos()));
        calculadoraDto.setGraficoProducaoUm(calculadora.getCustoManutencao() + calculadora.getCustoServicos());

        calculadoraDto.setProducaoDois(formatter.format(calculadora.getCustoManutencao() + calculadora.getCustoServicos() + uipath.getCustoMensalidade()));
        calculadoraDto.setGraficoProducaoDois(calculadora.getCustoManutencao() + calculadora.getCustoServicos() + uipath.getCustoMensalidade());
        return calculadoraDto;
    }

    private CalculadoraDto converteCalculadora(CalculadoraDto calculadoraDto, Calculadora calculadora) {
        calculadoraDto.setCustoProcesso(formatter.format(calculadora.getCustoProcesso()));
        calculadoraDto.setGraficoProcesso(calculadora.getCustoProcesso());

        calculadoraDto.setCustoDesenvolvimento(formatter.format(calculadora.getCustoDesenvolvimento()));
        calculadoraDto.setCustoImplementacao(formatter.format(calculadora.getCustoImplementacao()));
        calculadoraDto.setCustoManutencao(formatter.format(calculadora.getCustoManutencao()));
        calculadoraDto.setCustoServicos(formatter.format(calculadora.getCustoServicos()));
        return calculadoraDto;
    }

    private CalculadoraDto plataformas(CalculadoraDto calculadoraDto, Calculadora calculadora) {

        insereplataforma(calculadoraDto);
        reducaoCusto(calculadoraDto, calculadora);
        roi(calculadoraDto, calculadora);

        return calculadoraDto;
    }

    private CalculadoraDto insereplataforma(CalculadoraDto calculadoraDto) {
        calculadoraDto.setNomeplataformaUm(selenium.getNomePlataforma());
        calculadoraDto.setPlataformaUm(formatter.format(selenium.getCustoMensalidade()));
        calculadoraDto.setNomeplataformaDois(uipath.getNomePlataforma());
        calculadoraDto.setPlataformaDois(formatter.format(uipath.getCustoMensalidade()));
        return calculadoraDto;
    }

    private CalculadoraDto reducaoCusto(CalculadoraDto calculadoraDto, Calculadora calculadora) {
        calculadoraDto.setReducaoUm(formatter.format(calculadora.getCustoProcesso() - calculadora.getCustoDesenvolvimento() - calculadora.getCustoImplementacao() - calculadora.getCustoManutencao() - calculadora.getCustoServicos() - selenium.getCustoMensalidade()));
        calculadoraDto.setReducaoDois(formatter.format(calculadora.getCustoProcesso() - calculadora.getCustoDesenvolvimento() - calculadora.getCustoImplementacao() - calculadora.getCustoManutencao() - calculadora.getCustoServicos() - uipath.getCustoMensalidade()));
        return calculadoraDto;
    }

    private CalculadoraDto roi(CalculadoraDto calculadoraDto, Calculadora calculadora) {
        double reducao = calculadora.getCustoProcesso() - calculadora.getCustoDesenvolvimento() - calculadora.getCustoImplementacao() - calculadora.getCustoManutencao() - calculadora.getCustoServicos();
        double custo = calculadora.getCustoDesenvolvimento() + calculadora.getCustoImplementacao() + calculadora.getCustoManutencao() + calculadora.getCustoServicos();

        calculadoraDto.setRoiUm(String.format("%.2f%%",
                ((reducao - custo) / custo) * 100));

        calculadoraDto.setRoiDois(String.format("%.2f%%",
                (((reducao - uipath.getCustoMensalidade())
                        - custo) / custo) * 100));
        return calculadoraDto;
    }

//    private CalculadoraDto roi(CalculadoraDto calculadoraDto, Calculadora calculadora) {
//        double reducao = calculadora.getCustoProcesso() - calculadora.getCustoDesenvolvimento() - calculadora.getCustoImplementacao() - calculadora.getCustoManutencao() - calculadora.getCustoServicos();
//        double custo = calculadora.getCustoDesenvolvimento() + calculadora.getCustoImplementacao() + calculadora.getCustoManutencao() + calculadora.getCustoServicos();
//
//        calculadoraDto.setRoiUm(String.format("%.2f%%",
//                ((( reducao - selenium.getCustoMensalidade())
//                        - custo) / custo) * 100));
//
//        calculadoraDto.setRoiDois(String.format("%.2f%%",
//                ((( reducao - uipath.getCustoMensalidade())
//                        - custo) / custo) * 100));
//        return calculadoraDto;
//    }

}
