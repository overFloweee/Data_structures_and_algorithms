import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums, 0);
        return res;
    }

    public static void main(String[] args) {
        new Solution().findSubsequences(new int[]{1, 2, 1, 1});
    }


    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public void backTracking(int[] nums, int index) {
        if (path.size() >= 2) {
            res.add(new ArrayList<>(path));
        }

        for (int i = index; i < nums.length; ++i) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            if (!path.isEmpty() && path.peekLast() > nums[i]) {
                continue;
            }
            path.add(nums[i]);
            backTracking(nums, i + 1);
            path.removeLast();
        }
    }
}
