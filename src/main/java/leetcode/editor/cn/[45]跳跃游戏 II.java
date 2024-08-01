class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int preDistance = 0;
        int curtDistance = 0;
        int time = 0;
        for (int i = 0; i < nums.length; ++i) {
            curtDistance = Integer.max(curtDistance, i + nums[i]);
            if (i == preDistance) {
                preDistance = curtDistance;
                time++;
                if (curtDistance + 1 >= nums.length) {
                    break;
                }

            }
        }

        return time;
    }
}
