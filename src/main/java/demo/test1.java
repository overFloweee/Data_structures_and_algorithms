package demo;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author qifei
 * @since 2024-04-11
 */
public class test1
{
    public static void main(String[] args)
    {
        new test1().numSquares(13);


    }

    public int numSquares(int n)
    {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        HashSet<Integer> set = new HashSet<>();
        set.add(1);

        int late = 1;
        for (int i = 2; i <= n; i++)
        {

            int temp = i - late;

            if (isSquare(i))
            {
                dp[i] = 1;
                late = i;
                set.add(i);
            }
            else if (set.contains(temp))
            {
                dp[i] = 1 + dp[temp];

            }
            else
            {
                dp[i] = 1 + temp;
            }
        }

        System.out.println(Arrays.toString(dp));

        return dp[n];

    }

    public static boolean isSquare(int num)
    {
        double a;
        try
        {
            a = Math.sqrt(num);
        }
        catch (Exception e)
        {
            return false;
        }
        int b = (int) a;
        return a - b == 0;
    }
}
