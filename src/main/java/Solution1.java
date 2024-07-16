import java.util.Arrays;

class Solution1 {

    public static void main(String[] args) {
        // System.out.println(new Solution1().largestSumAfterKNegations(new int[]{4, 2, 3}, 1));
        System.out.println(new Solution1().largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2));
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];
            if (num < 0 && k > 0) {
                nums[i] = -1 * num;
                k--;
            }
            else if (k % 2 != 0) {
                nums[i] = -1 * num;
                k--;
            }
            sum += nums[i];
        }
        return sum;
    }
}
