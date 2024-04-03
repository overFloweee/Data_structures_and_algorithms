package practice;

import java.util.Arrays;

public class L27_移除元素
{
    public static void main(String[] args)
    {
        int[] nums = {1, 3, 2, 2, 3};
        int val = 3;
        System.out.println(new L27_移除元素().removeElement(nums, val));
        System.out.println(Arrays.toString(nums));
    }

    // 双指针
    public int removeElement(int[] nums, int val)
    {
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++)
        {
            if (nums[right] != val)
            {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;

    }

    // 双指针
    public int removeElement1(int[] nums, int val)
    {
        int left = 0, right = 0;
        while (right < nums.length)
        {
            if (nums[right] != val)
            {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }

        return left;

    }

    // 优化双指针
    public int removeElement2(int[] nums, int val)
    {
        int left = 0;
        int right = nums.length;
        while (left < right)
        {
            if (nums[left] == val)
            {
                nums[left] = nums[right - 1];
                right--;
            }
            else
            {
                left++;
            }
        }
        return left;

    }
}
