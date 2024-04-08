package exam.meituan_jishu5_2024_4_6;

import java.util.Arrays;

/**
 * @author qifei
 * @since 2024-04-06
 */
public class editDistance
{
    /**
     * 题目描述
     * 小美拿到了一个长度为7的字符串。她想知道将该字符串修改为"meituan"至少需要修改多少次？
     * <p>
     * 每次修改，小美可以修改任意一个字符。
     * <p>
     * 输入描述
     * 输入一个长度为7的字符串，字符串中只包含小写字母。
     * 输出描述
     * 小美需要修改的次数。
     * 样例
     * 输入
     * <p>
     * meituan
     * 输出
     * <p>
     * 0
     *
     * @param args
     */
    public static void main(String[] args)
    {
        String src = "abc";
        String target = "xyz";


        editDistance(src, target);
    }

    /**
     * 固定长度的 修改
     * 仅能解决该题目 且 必须从开头相等
     *
     * @param src
     * @param target
     */
    public static void minDistance1(String src, String target)
    {
        int ans = 0;
        for (int i = 0; i < 7; i++)
        {
            if (src.charAt(i) != target.charAt(i))
            {
                ans++;
            }
        }
        System.out.println("至少需要修改次数：" + ans);
    }

    /**
     * 任意两个距离的 距离计算
     *
     * @param src
     * @param target
     */
    public static void editDistance(String src, String target)
    {
        int m = src.length();
        int n = target.length();

        int[][] dp = new int[m + 1][n + 1];


        // 多加一层，才能计算 第 i 个字符串 的距离
        for (int i = 0; i <= m; i++)
        {
            dp[i][0] = i;
        }

        for (int i = 0; i <= n; i++)
        {
            dp[0][i] = i;
        }

        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                dp[i][j] = Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1);
                int temp;
                if (src.charAt(i - 1) == target.charAt(j - 1))
                {
                    temp = dp[i - 1][j - 1];
                }
                else
                {
                    temp = dp[i - 1][j - 1] + 1;
                }
                dp[i][j] = Math.min(temp, dp[i][j]);
            }
        }

        for (int[] ints : dp)
        {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("dp修改：" + dp[m][n]);
    }

}
