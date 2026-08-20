package br.pucrs.alest1;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escolha a função (1 a 6): ");
        int opcao = teclado.nextInt();

        switch (opcao)
        {
        case 1:
            System.out.println("Valor de N: Contador de Operações");
            for (int n = 100; n <= 10000; n += 100)
            {
                System.out.println(n + ";" + f1(n));
            }
            break;
        case 2:
            System.out.println("Valor de N: Contador de Operações");
            for (int n = 100; n <= 10000; n += 100)
            {
                System.out.println(n + ";" + f2(n));
            }
            break;
        case 3:
            System.out.println("Valor de N: Contador de Operações");
            for (int n = 10; n <= 1000; n += 10)
            {
                System.out.println(n + ";" + f3(n));
            }
            break;
        case 4:
            System.out.println("Valor de N: Contador de Operações");
            for (int n = 100; n <= 10000; n += 100)
            {
                System.out.println(n + ";" + f4(n));
            }
            break;
        case 5:
            System.out.println("Valor de N: Contador de Operações");
            for (int n = 100; n <= 10000; n += 100)
            {
                System.out.println(n + ";" + f5(n));
            }
            break;
        case 6:
            System.out.println("Valor de N: Contador de Operações");
            for (int n = 1; n <= 25; n++)
            {
                System.out.println(n + ";" + f6(n));
            }
            break;
        default:
            System.out.println("Opção inválida.");
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
            // System.out.println(i * j); // comentado: só deixa lento, não afeta a contagem
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
            return f6(n - 1) + f6(n - 1);
        }
    }
}
