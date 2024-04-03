package practice;

import java.util.Arrays;

/**
 * @author qifei
 * @since 2024-04-02
 */
public class L2548_填满背包的最大价格
{

    public static class item
    {
        public int weight;
        public int value;

        public item(int weight, int value)
        {
            this.weight = weight;
            this.value = value;
        }
    }

    // 有 n 个物品，它们有各自的重量和价值，现有给定容量的背包，如何让背包里装入的物品具有最大的价值总和？
    // 物品数量4 背包容量8

    /**
     * 物品编号	1	2	3	4
     * 重量   	2	3	4	5
     * 价值	    3	4	5	8
     */
    public static void main(String[] args)
    {
        int capacity = 8;
        int num = 4;
        item[] items = new item[]{
                new item(2, 3), new item(3, 4), new item(4, 5), new item(5, 8),
                // new item(4, 1600), new item(8, 2400), new item(5, 30), new item(1, 10_000),
        };

        // 二维数组 实现
        // two(items, num, capacity);

        // 一维数组 实现
        one(items, num, capacity);

    }


    public static void one(item[] items, int num, int capacity)
    {
        int[] dp = new int[capacity + 1];

        for (int j = 0; j < num; j++)
        {
            item item = items[j];
            // 一维数组求解，需要从右往左
            // 因为如果左往右，会修改旧数组 左边的值
            for (int i = capacity; i >= 0; i--)
            {
                if (i == 0)
                {
                    if (i >= item.weight)
                    {
                        dp[i] = item.value;
                    }
                    else
                    {
                        dp[i] = 0;
                    }
                }
                else
                {
                    if (i >= item.weight)
                    {
                        dp[i] = Integer.max(dp[i], item.value + dp[i - item.weight]);
                    }
                }
            }
        }

        System.out.println(Arrays.toString(dp));

    }


    public static void two(item[] items, int num, int capacity)
    {
        int[][] dp = new int[num][capacity + 1];

        // 初始化第一行
        item item0 = items[0];
        for (int i = 0; i < capacity + 1; i++)
        {
            // 装得下
            if (item0.weight <= i)
            {
                dp[0][i] = item0.value;
            }
            else
            {
                dp[0][i] = 0;
            }
        }


        for (int i = 1; i < num; i++)
        {
            item item = items[i];
            for (int j = 0; j < capacity + 1; j++)
            {
                // 装得下
                if (item.weight <= j)
                {
                    dp[i][j] = Integer.max(dp[i - 1][j], item.value + dp[i - 1][j - item.weight]);
                }
                else // 装不下
                {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        for (int i = 0; i < capacity + 1; i++)
        {
            System.out.print(" " + i + " ");
        }
        System.out.println();
        System.out.println("------------------------------");
        for (int[] ints : dp)
        {
            System.out.println(Arrays.toString(ints));
        }
    }
}
