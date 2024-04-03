package practice;

public class L26_删除有序数组中的重复项
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{
                0, 0, 1, 1, 1, 2, 2, 3, 3, 4
        };
        System.out.println(new L26_删除有序数组中的重复项().removeDuplicates(nums));
    }

    // 二解
    public int removeDuplicates(int[] nums)
    {
        if (nums.length == 1)
        {
            return 1;
        }
        int p1 = 0;
        int p2 = 1;
        int index = 1;
        do
        {
            if (nums[p1] == nums[p2])
            {
                p2++;
            }
            else
            {
                nums[index] = nums[p2];
                index++;
                p1 = p2;
            }
        } while (p2 < nums.length);

        return index;
    }

    // 初解
    public int removeDuplicates2(int[] nums)
    {
        int p1 = 0, p2 = 0;
        if (nums.length == 1)
        {
            return nums.length;
        }


        while (p2 < nums.length)
        {

            if (nums[p2] != nums[p2 + 1])
            {
                nums[p1] = nums[p2];
                p1++;

            }
            p2++;


            if (p2 == nums.length - 1)
            {
                nums[p1] = nums[p2];
                p1++;
                break;
            }

        }

        return p1;
    }

    // 优解
    public int removeDuplicates3(int[] nums)
    {
        int index = 0;
        for (int i = 1; i < nums.length; i++)
        {
            // 找到不重复的元素，赋值到数组的开头
            if (nums[i] != nums[index])
            {
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }
}
