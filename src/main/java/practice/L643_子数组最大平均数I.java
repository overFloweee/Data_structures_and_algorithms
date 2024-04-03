package practice;

public class L643_子数组最大平均数I
{
    public static void main(String[] args)
    {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 3;
        System.out.println(new L643_子数组最大平均数I().findMaxAverage2(nums, k));  // 47 / 3 = 15.667
    }

    // 耗时太长
    public double findMaxAverage(int[] nums, int k)
    {
        int p1 = 0, p2 = p1 + k - 1;
        int[] arr = new int[k];

        int max = Integer.MIN_VALUE, temp = 0;
        while (p2 <= nums.length - 1)
        {

            System.arraycopy(nums, p1, arr, 0, k);
            for (int i : arr)
            {
                temp += i;
            }
            if (temp > max)
            {
                max = temp;
            }
            p1++;
            p2++;
            temp = 0;
        }
        return (double) max / k;
    }

    // 升级版
    public double findMaxAverage1(int[] nums, int k)
    {

        int p1 = 1, p2 = p1 + k - 1;
        int temp = 0;
        for (int i = 0; i < k; i++)
        {
            temp += nums[i];
        }
        int max = temp;
        // *
        while (p2 < nums.length)
        {

            temp = temp + nums[p2] - nums[p1 - 1];
            max = Math.max(temp, max);
            p1++;
            p2++;
        }
        return (double) max / k;
    }

    public double findMaxAverage2(int[] nums, int k)
    {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < k; i++)
        {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < n; i++)
        {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return 1.0 * maxSum / k;
    }


}
