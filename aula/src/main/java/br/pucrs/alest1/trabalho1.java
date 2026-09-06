package br.pucrs.alest1;
import java.util.Scanner;

public class trabalho1 {
    public static void main(String[] args)
    {
        int[] valoresDeN = {3, 10, 20, 40, 60, 90, 120, 200};
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escolha a função (1 a 5): ");
        int opcao = teclado.nextInt();

        switch (opcao)
        {
            case 1:
            System.out.println("n;operacoes;tempo(ms)");
            for (int n : valoresDeN)
            {
                long antes = System.nanoTime();
                int operacoes = algoritmo1(n);
                long depois = System.nanoTime();
                double tempoMs = (depois - antes) / 1_000_000.0;

                System.out.println(n + ";" + operacoes + ";" + tempoMs);
            }
                break;
            case 2:
            System.out.println("n;operacoes;tempo(ms)");
            for (int n : valoresDeN)
            {
                long antes = System.nanoTime();
                int operacoes = algoritmo2(n);
                long depois = System.nanoTime();
                double tempoMs = (depois - antes) / 1_000_000.0;

                System.out.println(n + ";" + operacoes + ";" + tempoMs);
            }
                break;
            case 3:
            System.out.println("n;operacoes;tempo(ms)");
            for (int n : valoresDeN)
            {
                long antes = System.nanoTime();
                int operacoes = algoritmo3(n);
                long depois = System.nanoTime();
                double tempoMs = (depois - antes) / 1_000_000.0;

                System.out.println(n + ";" + operacoes + ";" + tempoMs);
            }
                break;
            case 4:
            System.out.println("n;operacoes;tempo(ms)");
            for (int n : valoresDeN)
            {
                long antes = System.nanoTime();
                int operacoes = algoritmo4(n);
                long depois = System.nanoTime();
                double tempoMs = (depois - antes) / 1_000_000.0;

                System.out.println(n + ";" + operacoes + ";" + tempoMs);
            }
                break;
            case 5:
            System.out.println("n;operacoes;tempo(ms)");
            for (int n : valoresDeN)
            {
                long antes = System.nanoTime();
                int operacoes = algoritmo5(n);
                long depois = System.nanoTime();
                double tempoMs = (depois - antes) / 1_000_000.0;

                System.out.println(n + ";" + operacoes + ";" + tempoMs);
            }
                break;
            default:
            System.out.println("Opção inválida.");
        }
        teclado.close();
    }

    public static int algoritmo1(int n)
    {
        int i, j, k, res = 0;
        int cont_op = 0;
        for (i = 1; i <= n * n; i += 1)
        {
            for (j = 1; j <= i; j += 2)
            {
                for (k = n + 1; k <= 2 * i; k += i * j)
                {
                    res = res + k + 1;
                    cont_op++;
                }
            }
        }
        return cont_op;
    }

    public static int algoritmo2(int n)
    {
        int i, j, k, res = 0;
        int cont_op = 0;
        for (i = n; i <= n; i += i/2+1)
        {
            for (j = i/2; j <= i*i; j += i+1)
            {
                for (k = n; k <= 2*n; k += i+1)
                {
                    res = res + n;
                    cont_op++;
                }
            }
        }
        return cont_op;
    }

    public static int algoritmo3(int n)
    {
        int i, j, k, res = 0;
        int cont_op = 0;
        for(i = 1; i <= n*n; i += 2 )
        {
            for( j = i/2; j <= 2*i; j += i/2+1 )
            {
                for( k = j+1; k <= n+j; k += k/2+1)
                {
                    res = res + Math.abs(j-i);
                    cont_op++;
                }
            }
        }
        return cont_op;
    }

    public static int algoritmo4(int n)
    {
        int i, j, k, res = 0;
        int cont_op = 0;
        for(i = 1; i <= n*n; i += 2)
        {
            for(j = 2; j <= n+1; j += i+1)
            {
                for(k = j/2; k <= i+1; k += j/2+1 )
                {
                    res = res + j+1;
                    cont_op++;
                }
            }
        }
        return cont_op;
    }

    public static int algoritmo5(int n)
    {
        int i, j, k, res = 0;
        int cont_op = 0;
        for( i = n/2; i <= n; i += 3 )
        {
            for( j = i; j <= i*i; j += 2 )
            {
                for( k = i; k <= 2*j; k += 1 )
                {
                    res = res + n+j;
                    cont_op++;
                }
            }
        }
        return cont_op;
    }
}
