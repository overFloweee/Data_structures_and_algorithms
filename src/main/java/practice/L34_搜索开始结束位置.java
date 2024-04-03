package practice;

import java.util.Arrays;

public class L34_搜索开始结束位置
{
    public static void main(String[] args)
    {
        // int[] nums = {5, 7, 7, 8, 8, 10};
        int[] nums = {};
        int target = 8;
        int[] ints = new L34_搜索开始结束位置().searchRange(nums, target);
        System.out.println(Arrays.toString(ints));
    }

    public int[] searchRange(int[] nums, int target)
    {
        int[] resultArr = {-1, -1};
        // leftmost 基础版，不需要升级版
        int i = 0;
        int j = nums.length -1 ;
        int candidate = -1;
        while (i <= j)
        {
            int m = (i + j) >>> 1;
            if (target < nums[m])
            {
                j = m - 1;
            }
            else if (nums[m] < target)
            {
                i = m + 1;
            }
            else
            {
                candidate = m; // 记录候选位置
                j = m - 1;     // 继续向左
            }
        }
        int leftIndex = candidate;


        // rightmost
        i = 0;
        j = nums.length -1 ;
        candidate = -1;
        while (i <= j)
        {
            int m = (i + j) >>> 1;
            if (target < nums[m])
            {
                j = m - 1;
            }
            else if (nums[m] < target)
            {
                i = m + 1;
            }
            else
            {
                candidate = m; // 记录候选位置
                i = m + 1;       // 继续向右
            }
        }
        int rightIndex = candidate;

        if (leftIndex != -1)
        {
            resultArr[0] = leftIndex;
            resultArr[1] = rightIndex;
        }
        return resultArr;

    }
}
