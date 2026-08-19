package br.pucrs.alest1;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escolha a função (1 a 6): ");
        int opcao = teclado.nextInt();

        System.out.println("n, tempo(ms)"); // cabeçalho, facilita colar na planilha

        for (int n = 1; n <= 10000; n++)
        {
            long antes = System.currentTimeMillis();

            switch (opcao)
            {
            case 1:
                f1(n);
                break;
            case 2:
                f2(n);
                break;
            case 3:
                f3(n);
                break;
            case 4:
                f4(n);
                break;
            case 5:
                f5(n);
                break;
            case 6:
                f6(n);
                break;
            default:
                System.out.println("Opção inválida.");
            }

            long depois = System.currentTimeMillis();
            long total = depois - antes;

            System.out.println(n + ", " + total);
        }

                teclado.close();
            }

    public static int f1(int n)
    {
        int r = 0;
        for (int i = 1; i < n; i++)
        {
            r = r + 1;
        }
        return r;
    }

    public static int f2(int n)
    {
        int r = 0;
        for (int i = 1; i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                r = r + 2;
            }
        }
        return r;
    }

    public static int f3(int n)
    {
        int cont = 0;
        for (int i = 1; i < n; i++)
        {
            for (int j = 1; j < n; j++)
            {
                System.out.println(i * j);
                cont++;
            }
        }
        return cont;
    }

    public static int f4(int n)
    {
        int r = 0;
        for (int i = 1; i < n; i++)
        {
            for (int j = i; j < 2 * i; j++)
            {
                for (int k = i; k < j; k++)
                {

                }
                r = r + 1;
            }
        }
        return r;
    }

    public static int f5(int n)
    {
        int r = 0;
        for (int i = 1; i < n; i++)
        {
            for (int j = i; j < i + 3; j++)
            {
                for (int k = i; k < j; k++)
                r = r + 1;
            }
        }
        return r;
    }

    public static int f6(int n)
    {
        if (n == 0)
        {
            return 1;
        } else
        {
            return f6 (n - 1) + f6(n - 1);
        }
    }
}

