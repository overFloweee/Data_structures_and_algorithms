package practice;


import java.util.Arrays;
import java.util.HashSet;

// * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数
public class L268_丢失的数字
{
    public static void main(String[] args)
    {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};  // 8
        int i = new L268_丢失的数字().missingNumber2(nums);
        System.out.println(i);
    }

    // 基础版本   排序  O( nlog(n) )
    public int missingNumber(int[] nums)
    {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++)
        {
            if (i != nums[i])
            {
                return i;
            }
        }

        // *
        return n;
    }

    // 哈希集合   O(n)
    // 首先遍历数组 nums ，将数组中的每个元素加入哈希集合，
    // 然后依次检查从 0 到 n 的每个整数是否在哈希集合中，不在哈希集合中的数字即为丢失的数字
    public int missingNumber1(int[] nums)
    {

        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++)
        {
            set.add(nums[i]);
        }

        for (int i = 0; i < n; i++)
        {
            if (!set.contains(i))
            {
                return i;
            }
        }

        return n;
    }


    // 位运算
    public int missingNumber2(int[] nums)
    {
        int xor = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            xor ^= nums[i];
        }
        for (int i = 0; i <= n; i++) {
            xor ^= i;
        }
        return xor;

    }


}
