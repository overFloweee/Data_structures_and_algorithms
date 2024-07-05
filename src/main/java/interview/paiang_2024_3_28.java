package interview;

import java.util.ArrayList;

/**
 * @author qifei
 * @since 2024-03-28
 */
public class paiang_2024_3_28
{
    /**
     * LEETCODE 209. 长度最小的子数组
     *
     * @param args
     */
    public static void main(String[] args)
    {
        int[] arr = {2, 3, 1, 2, 4, 3};
        // int[] arr = {1, 1, 1, 1, 1, 1, 1, 1};
        // int[] arr = {1, 2, 3, 4, 5};
        int length = minSubArrayLen2(arr, 7);
        System.out.println(length);
    }

    // 滑动窗口 - 优解
    public static int minSubArrayLen2(int[] nums, int target)
    {
        int n = nums.length;
        int min = Integer.MAX_VALUE;

        int p1 = 0;
        int p2 = 0;
        int temp = 0;
        while (p2 < n)
        {
            temp += nums[p2];
            // 内层循环在 缩短 数组长度
            while (temp >= target)
            {
                min = Integer.min(min, p2 - p1 + 1);
                temp -= nums[p1];
                p1++;
            }
            p2++;
        }

        return Integer.MAX_VALUE == min ? 0 : min;
    }


    // 初解优化  - 官解  - 超时
    public static int minSubArrayLen1(int[] nums, int target)
    {
        int n = nums.length;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++)
        {
            int temp = 0;
            for (int j = i; j >= 0; j--)
            {
                temp += nums[j];
                if (temp >= target)
                {
                    temp = i - j + 1;
                    min = Math.min(min, temp);
                    break;
                }
            }
        }

        return Integer.MAX_VALUE == min ? 0 : min;


    }

    // 初解 超时
    public static int minSubArrayLen(int[] nums, int target)
    {
        int n = nums.length;
        int min = Integer.MAX_VALUE;

        boolean flag = false;
        for (int i = 0; i < n; i++)
        {
            int temp = 0;
            flag = false;
            for (int j = i; j >= 0; j--)
            {
                temp += nums[j];
                if (temp >= target)
                {
                    temp = i - j + 1;
                    flag = true;
                    break;
                }
            }
            if (flag)
            {
                min = Math.min(min, temp);
            }
        }

        return flag ? min : 0;


    }


}
