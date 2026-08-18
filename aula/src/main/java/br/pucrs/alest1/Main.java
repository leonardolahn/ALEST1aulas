package br.pucrs.alest1;
public class Main
{
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

