package br.com.ifto;

import java.util.List;

public interface LeituraRetorno {

    List<Boleto> lerArquivo(String caminhoArquivo);

}
