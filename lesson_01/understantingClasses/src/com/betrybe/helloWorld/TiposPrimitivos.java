package com.betrybe.helloWorld;

public class TiposPrimitivos {
    public static void main(String[] args) {
        short num = 300;
        short formatadaComUndescore = 20_000; // variavel
        System.out.println(num);
        System.out.println(formatadaComUndescore); // 200000

        int numeroInteiro = 10;
        int a = 10, b = 20, soma;
        soma = a + b;
        System.out.println(numeroInteiro);
        System.out.println(soma);

        long numbA = 102040;
        long numbB = 102030405060L;
        System.out.println(numbA);
        System.out.println(numbB);

        float numA = -101.23f;
        float numB = 2.356f;
        System.out.println(numA + numB); // -98.874

        double valorUm = 0.5; // double inicializado naturalmente
        double valorDois = 0.5d; // double definido explicitamente
        double valorTres = 0.123456789; // várias casas decimais
        System.out.println(valorUm); // 0.5
        System.out.println(valorDois); // 0.5
        System.out.println(valorTres); // 0.123456789

        boolean isBoolean = true; // outros exemplos: isGreaterThan, isFlexible, isStarted
        boolean ehNumero = false; // outros exemplos: ehMaiorDeIdade, ehCedo, ehValido

        char letraA = 'a';
        char letraAMaiuscula = 'A';
        System.out.println(letraA); // a
        System.out.println(letraAMaiuscula); // A
    }
}
