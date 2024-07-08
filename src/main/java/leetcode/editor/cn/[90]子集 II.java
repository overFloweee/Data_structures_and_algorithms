// 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的 子集（幂集）。
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
//
//
//
//
//
//
//
// 示例 1：
//
//
// 输入：nums = [1,2,2]
// 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
//
//
// 示例 2：
//
//
// 输入：nums = [0]
// 输出：[[],[0]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
//
//
// Related Topics 位运算 数组 回溯 👍 1217 👎 0


// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    // 初解 - 非常困难的完成了
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int index = 0;
        Arrays.sort(nums);
        backTracking(nums, index);
        return res;
    }

    public void backTracking(int[] nums, int index) {
        res.add(new ArrayList<>(path));

        for (int i = index; i < nums.length; ++i) {
            path.add(nums[i]);
            backTracking(nums, i + 1);
            int last = path.get(path.size() - 1);
            while (i < nums.length - 1 && last == nums[i + 1]) {
                i++;
            }
            path.remove(path.size() - 1);
        }
    }
}
// leetcode submit region end(Prohibit modification and deletion)
