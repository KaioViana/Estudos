package Dados;
/*Classe Dados.java
 Aplicativo para simular o lançamento de dois dados. O aplicativo utiliza um
 objeto de classe Random, uma vez para lançar o primeiro dado e novamente para
 lançar o segundo dado. A soma dos dois valores deve então é calculada.
 Cada dado pode mostrar um valor inteiro de 1 a 6, portanto a soma dos valores
 irá variar de 2 a 12, com 7 sendo a soma mais frequente e 2 e 12,
 as somas menos frequentes. O aplicativo lança o dado 36.000.000 vezes.
 Utiliza um array unidimensional para contar o número de vezes que cada possível
 soma aparece. Exibe os resultados em formato tabular.
*/

import java.security.SecureRandom;
import java.util.Arrays;

public class Dados {

    public static void main(String[] args) {

        SecureRandom numbers = new SecureRandom();
        int comp = 2;// Valores possíveis da soma das faces de dois dados (2 ao 12).
        int cont = 0;// Contatdor de vezes que o número aparece
        int face = 1;// Condição de do{}whilhe();
        int c = 0;// Índices do array vetor
        int soma;// Soma das faces
        int dado1;// Dado
        int dado2;// Dado
        int[] vetor = new int[36000];
        int[][] array = new int[6000][6000];
        // Lança os dados  36000.000 e armazena a soma de suas faces no vetor
        for (int i = 0; i < vetor.length; i++) {
            dado1 = 1 + numbers.nextInt(6);
            dado2 = 1 + numbers.nextInt(6);
            soma = dado1 + dado2;
            vetor[i] = soma;

        }
        // Armazena a soma do lançamento na tabela
        for (int[] array1 : array) {
            for (int coluna = 0; coluna < array.length; coluna++) {
                array1[coluna] = vetor[c];
                c++;
            }
        }
        // Põe a tabela em ordem
        for (int[] array1 : array) {
            Arrays.sort(array1);
        }
        // Printa tabela de soma das faces de cada lançamento
        for (int[] array1 : array) {
            for (int j = 0; j < array.length; j++) {
                System.out.printf("%-3d ", array1[j]);
            }
            System.out.println();
        }

        System.out.println();
        // Conta a quantidade de vezes que cada número aparece
        do {
            for (int[] array1 : array) {
                for (int coluna = 0; coluna < array.length; coluna++) {
                    if (comp == array1[coluna]) {
                        cont++;
                    }
                }
            }
            System.out.println("O número " + comp + " aparece " + cont
                    + " vezes");

            cont = 0;
            face++;
            comp++;

        } while (face < 12);
    }
}
