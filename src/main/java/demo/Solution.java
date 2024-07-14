package demo;

public class Solution {
    public boolean canJump(int[] nums) {
        return backTrack(nums, 0);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canJump(new int[]{2, 0, 0}));
    }

    public boolean backTrack(int[] nums, int index) {
        if (index + 1 >= nums.length) {
            return true;
        }


        for (int i = 1; i <= nums[index]; ++i) {
            // index是当前的位置
            // index + i是马上要跳跃到的位置
            if (backTrack(nums, index + i)) {
                return true;
            }
        }

        return false;
    }
}

