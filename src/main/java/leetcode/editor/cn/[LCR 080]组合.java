//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
//
//
// 示例 1:
//
//
//输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
//
// 示例 2:
//
//
//输入: n = 1, k = 1
//输出: [[1]]
//
//
//
// 提示:
//
//
// 1 <= n <= 20
// 1 <= k <= n
//
//
//
//
//
// 注意：本题与主站 77 题相同： https://leetcode-cn.com/problems/combinations/
//
// Related Topics 数组 回溯 👍 62 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    // 15 ms 击败 63.60%
    public List<List<Integer>> combine(int n, int k) {

        backTracking(n, k, 1);
        return res;
    }

    public void backTracking(int n, int k, int index) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = index; i <= n; ++i) {
            path.add(i);
            backTracking(n, k, i + 1);
            path.removeLast();
        }


    }
}
//leetcode submit region end(Prohibit modification and deletion)
