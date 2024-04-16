package demo;

import java.util.Scanner;

/**
 * @author qifei
 * @since 2024-04-07
 */
public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int a = in.nextInt();
        for (int i = 0; i < a; i++)
        {

            int n = in.nextInt();
            int sum = in.nextInt();
            System.out.println();
            test(n, sum);

        }

    }

    public static void test(int n, int sum)
    {
        for (int i = 1; i <= n; i++)
        {
            sum ^= i;
        }
        System.out.println(sum);
    }
}
