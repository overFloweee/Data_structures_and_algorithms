class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        for(int i = 1; i < nums.length; ++i) {
            if (nums[i] != nums[i-1]) {
                return nums[i-1];
            }
            else {
                i++;
            }
        }

        return nums[n - 1];

    }

    public int singleNumber(int[] nums) {
        int num = 0;
        int n = nums.length;
        for(int i = 0; i < nums.length; ++i) {
            num ^= nums[i];
        }

        return num;

    }

}
