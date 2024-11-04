package br.com.ifto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static br.com.ifto.ProcessarBoletos.FORMATO_DATA;
import static br.com.ifto.ProcessarBoletos.FORMATO_DATA_HORA;

public class LeituraRetornoBradesco {

    public List<Boleto> lerBoletoBradesco(String caminhoArquivo) {
        try {
            List<String> linhas = Files.readAllLines(Path.of(caminhoArquivo));
            var boletos = new ArrayList<Boleto>(linhas.size());
            for (String linha : linhas) {
                String[] vetor = linha.split(";");
                var boleto = new Boleto();
                boleto.setId(Integer.parseInt(vetor[0]));
                boleto.setCodBanco(String.valueOf((vetor[1])));
                boleto.setAgencia(String.valueOf((vetor[2])));
                boleto.setContaBancaria(String.valueOf((vetor[3])));
                boleto.setDataVencimento(LocalDate.parse(vetor[4], FORMATO_DATA));
                boleto.setDataPagamento(LocalDateTime.parse(vetor[5], FORMATO_DATA_HORA));
                boleto.setCpfCliente(vetor[6]);
                boleto.setValor(Double.parseDouble(vetor[7]));
                boleto.setJuros(Double.parseDouble(vetor[8]));
                boleto.setMulta(Double.parseDouble(vetor[9]));
                boletos.add(boleto);
            }
            return boletos;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
