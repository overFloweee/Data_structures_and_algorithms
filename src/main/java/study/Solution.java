package study;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        new Solution().subsetsWithDup(new int[]{1, 2, 2});
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int index = 0;
        backTracking(nums, index);
        return res;
    }

    public void backTracking(int[] nums, int index) {
        res.add(new ArrayList<>(path));

        for (int i = index; i < nums.length; ++i) {
            path.add(nums[i]);
            backTracking(nums, i + 1);
            path.remove(path.size() - 1);
        }


    }
}
