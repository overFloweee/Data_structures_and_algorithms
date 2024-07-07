////给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
////
//// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
////
////
////
//// 示例 1：
////
////
////输入：nums = [1,2,3]
////输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
////
////
//// 示例 2：
////
////
////输入：nums = [0]
////输出：[[],[0]]
////
////
////
////
//// 提示：
////
////
//// 1 <= nums.length <= 10
//// -10 <= nums[i] <= 10
//// nums 中的所有元素 互不相同
////
////
//// Related Topics 位运算 数组 回溯 👍 2315 👎 0
//


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int index = 0;
        backTracking(nums, index);
        return res;
    }

    public void backTracking(int[] nums, int index) {
        // 这里必须新建一个ArrayList，如果直接传递path
        // res里面的元素全部都是引用同一个path对象。
        // 这会导致所有的res中的引用都指向最终的path状态。
        res.add(new ArrayList<>(path));

        for (int i = index; i < nums.length; ++i) {
            path.add(nums[i]);
            backTracking(nums, i + 1);
            path.remove(path.size() - 1);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
