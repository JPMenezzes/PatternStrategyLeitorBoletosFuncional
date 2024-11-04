package br.com.ifto;

public class Principal {
    public static void main(String[] args) {

        var leituraRetornoBancoBrasil = new LeituraRetornoBancoBrasil();
        var processadorBrasil = new ProcessarBoletos(leituraRetornoBancoBrasil::lerBoletoBancoDoBrasil);

        //processadorBrasil.setLeituraRetorno(leituraRetornoBancoBrasil::lerBoletoBancoDoBrasil);
        processadorBrasil.processar("banco-brasil-1.csv");
        System.out.println(processadorBrasil.getLeituraRetorno().toString());

        System.out.println();

        var leituraRetornoBradesco = new LeituraRetornoBradesco();
        var processadorBradesco = new ProcessarBoletos(leituraRetornoBradesco::lerBoletoBradesco);

        //processadorBradesco.setLeituraRetorno(leituraRetornoBradesco::lerBoletoBradesco);
        processadorBradesco.processar("bradesco-1.csv");
        System.out.println(processadorBradesco.getLeituraRetorno().toString());

        /**
         * o uso de :: permite passar o método como uma referência funcional, compatível com o tipo Function<String, List<Boleto>>,
         * sem precisar executá-lo imediatamente.
         */

    }
}