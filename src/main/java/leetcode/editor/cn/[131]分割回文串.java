// 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
//
//
//
// 示例 1：
//
//
// 输入：s = "aab"
// 输出：[["a","a","b"],["aa","b"]]
//
//
// 示例 2：
//
//
// 输入：s = "a"
// 输出：[["a"]]
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 16
// s 仅由小写英文字母组成
//
//
// Related Topics 字符串 动态规划 回溯 👍 1805 👎 0


import java.util.ArrayList;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<String>> res = new ArrayList<>();
    ArrayList<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        char[] charArr = s.toCharArray();
        int startIndex = 0;
        method(s, startIndex);
        new StringBuilder().i
        return res;
    }

    public void method(String s, int startIndex) {
        if (startIndex + 1 > s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); ++i) {
            // 如果是回文子串，则记录
            if (isPalindrome(s, startIndex, i)) {
                String temp = s.substring(startIndex, i + 1);
                path.add(temp);
            }
            else {
                // 不是回文串，都没有后续元素递归的机会
                continue;
            }

            method(s, i + 1);
            path.remove(path.size() - 1);
        }

    }

    // 判断是否是回文串
    private boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
// leetcode submit region end(Prohibit modification and deletion)
