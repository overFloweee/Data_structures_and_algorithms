package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L1_两数之和
{
    public static void main(String[] args)
    {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] ints = new L1_两数之和().twoSum2(nums, target);
        System.out.println(Arrays.toString(ints));
        
    }

    public int[] twoSum(int[] nums, int target)
    {
        int p1 = 0, p2 = nums.length - 1;
        int temp;
        while (p1 <= p2)
        {
            temp = nums[p1] + nums[p2];
            if (temp != target)
            {
                p2--;
            }
            else
            {
                break;
            }
            if (p1 == p2)
            {
                p1++;
                p2 = nums.length - 1;
            }

        }
        return new int[]{p1, p2};

    }

    // 2ms
    public int[] twoSum1(int[] nums, int target)
    {
        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < nums.length; ++i)
        {
            if (hashtable.containsKey(target - nums[i]))
            {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    // 0ms
    public int[] twoSum2(int[] nums, int target)
    {
        for (int len = 1; len < nums.length; len++)
            for (int i = 0; i + len < nums.length; i++)
                if (nums[i] + nums[i + len] == target)
                {
                    return new int[]{i, i + len};
                }

        return new int[]{};


    }

}
