// 给定一个可包含重复数字的整数集合 nums ，按任意顺序 返回它所有不重复的全排列。
//
//
//
// 示例 1：
//
//
// 输入：nums = [1,1,2]
// 输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
//
//
// 示例 2：
//
//
// 输入：nums = [1,2,3]
// 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 8
// -10 <= nums[i] <= 10
//
//
//
//
//
// 注意：本题与主站 47 题相同： https://leetcode-cn.com/problems/permutations-ii/
//
// Related Topics 数组 回溯 👍 67 👎 0


import java.util.ArrayList;
import java.util.Arrays;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backTracking(nums);
        return res;

    }

    public void backTracking(int[] nums) {
        if (nums.length == path.size()) {
            res.add(new ArrayList<>(path));
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1]) {
                continue;
            }
            if (used[i]) {
                continue;
            }

            used[i] = true;
            path.add(nums[i]);
            backTracking(nums);
            used[i] = false;
            path.removeLast();
        }
    }
}
// leetcode submit region end(Prohibit modification and deletion)
