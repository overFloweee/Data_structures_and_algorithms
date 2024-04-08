package demo;

import javax.swing.plaf.IconUIResource;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author qifei
 * @since 2024-04-07
 */
public class demo
{
    public static void main(String[] args)
    {

        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();  // 小孩
        int m = in.nextInt();  // 苹果
        // int k = in.nextInt();

        // int n = 4;
        // int m = 6;


        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
        {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= n; i++)
        {
            dp[0][n] = 0;
        }


        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {

                int temp = 0;
                if (j == 1)
                {
                    dp[i][1] = i;
                }
                else
                {
                    if (i % j == 0)
                    {
                        temp = i / j;
                    }
                    else
                    {
                        temp = i / j + 1;
                    }
                    dp[i][j] = temp;
                }
                if (i < j)
                {
                    dp[i][j] = 0;
                }
            }
        }

        for (int[] ints : dp)
        {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println(dp[m][n]);

    }

}
