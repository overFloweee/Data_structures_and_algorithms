package study;

import java.util.Arrays;

public class P52_斐波那契数列
{
    public static void main(String[] args)
    {
        int f = fib2(0);
        System.out.println(f);
    }

    // 递归 Time Limit Exceeded
    public static int f(int n)
    {
        if (n == 0)
        {
            return 0;
        }
        if (n == 1)
        {
            return 1;
        }

        return f(n - 1) + f(n - 2);
    }


    // 数组存储
    public static int fib(int n)
    {
        int[] cache = new int[n + 1];

        Arrays.fill(cache, -1);
        cache[0] = 0;
        cache[1] = 1;

        return fib1(n, cache);

    }

    // 直接递归会 Time Limit Exceeded
    public static int fib1(int n, int[] cache)
    {
        if (cache[n] != -1)
        {
            return cache[n];
        }

        int i = fib1(n - 1, cache);
        int j = fib1(n - 2, cache);
        cache[n] = i + j;

        return cache[n];

    }


    // 数组存储
    public static int fib2(int n)
    {
        int[] cache = new int[n + 1];

        Arrays.fill(cache, -1);
        cache[0] = 0;
        cache[1] = 1;

        return fib3(n, cache);

    }

    // 直接递归会 Time Limit Exceeded
    public static int fib3(int n, int[] cache)
    {
        if (cache[n] != -1)
        {
            return cache[n] % 1000000007;
        }

        int i = fib3(n - 1, cache);
        int j = fib3(n - 2, cache);
        cache[n] = (i + j) % 1000000007;

        return cache[n];

    }

}
