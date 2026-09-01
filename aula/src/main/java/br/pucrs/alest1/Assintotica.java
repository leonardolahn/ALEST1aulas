package main.java.br.pucrs.alest1;

import java.util.Scanner;

public class Assintotica {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int[] vetor = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println("Digite o valor alvo (1 a 10): ");
        int alvo = teclado.nextInt();

        System.out.println(buscaLinear(vetor, alvo));
        System.out.println(buscaBinaria(vetor, alvo));
    }

    public static int buscaLinear(int[] vetor, int alvo)
    {
        for (int i = 0; i < vetor.length - 1; i++)
        {
            if (vetor[i] == alvo)
            {
                return i;
            }
        }
        return -1;
    }

    public static int buscaBinaria(int[] vetor, int alvo) {
        int inicio = 0;
        int fim = vetor.length - 1;
        while (inicio <= fim)
        {
            int meio = (inicio + fim) / 2;
        }
        if (vetor[meio] == alvo)
            {
                return meio;
            }
            else if (vetor[meio] < alvo)
            {
                inicio = meio + 1;
            }
            else
            {
                fim = meio - 1;
            }
            return -1;
    }
}
