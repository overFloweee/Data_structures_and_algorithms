class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int max = 0;
        int num = 1;
        int last = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] == last + 1) {
                num++;
                last++;
            }
            else {
                max = Math.max(max, num);
                num = 1;
                last = nums[i];
            }
        }

        return Math.max(max, num);
    }
}
