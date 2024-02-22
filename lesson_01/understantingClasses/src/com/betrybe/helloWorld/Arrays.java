package com.betrybe.helloWorld;
import java.lang.*;

public class Arrays {
    public static void main(String[] args) {
        int[] arrayDeInteiros = {1,2,3,4,5,6,767,878,8,8,9,9,9};
        int[][] matriz = new int[2][10]; // inicializamos a matriz, seriam 2 arrays com 10 idex cada
        String[] arrayDeString = new String[10];

        matriz[0][0] = 10;
        matriz[1][0] = 20;

        arrayDeString[0] = "Na Trybe";
        arrayDeString[1] = "eu aprendo Java!";

        System.out.println(arrayDeInteiros[3]);
        System.out.println(matriz[0][0]);
        System.out.println(matriz[1][5]);
        System.out.println(arrayDeString[0] + arrayDeString[1]);
        System.out.println(arrayDeString.length);
    }
}
