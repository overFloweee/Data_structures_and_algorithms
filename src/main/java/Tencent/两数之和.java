package Tencent;

/**
 * @author qifei
 * @since 2024-03-29
 */
public class 两数之和
{
    public static void main(String[] args)
    {
        new 两数之和().twoSum(new int[]{3, 2, 3}, 6);

    }

    public int[] twoSum(int[] nums, int target)
    {
        int p1 = 0;
        int p2 = 1;
        while (p2 < nums.length)
        {
            int num = nums[p1] + nums[p2];
            if (num == target)
            {
                return new int[]{p1, p2};
            }
            else
            {
                p2++;
            }
            if (p2 == nums.length - 1)
            {
                p1++;
                p2 = p1 + 1;
            }

        }
        return new int[0];

    }
}
