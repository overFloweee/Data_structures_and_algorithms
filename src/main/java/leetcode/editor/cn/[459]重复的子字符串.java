// 给定一个非空的字符串
// s ，检查是否可以通过由它的一个子串重复多次构成。
//
//
//
// 示例 1:
//
//
// 输入: s = "abab"
// 输出: true
// 解释: 可由子串 "ab" 重复两次构成。
//
//
// 示例 2:
//
//
// 输入: s = "aba"
// 输出: false
//
//
// 示例 3:
//
//
// 输入: s = "abcabcabcabc"
// 输出: true
// 解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
//
//
//
//
// 提示：
//
//
//
//
//
// 1 <= s.length <= 10⁴
// s 由小写英文字母组成
//
//
// Related Topics 字符串 字符串匹配 👍 1174 👎 0


// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 初解
    // 执行耗时:585 ms,击败了5.01% 的Java用户
    // 内存消耗:44.2 MB,击败了28.15% 的Java用户
    public boolean repeatedSubstringPattern1(String s) {
        int n = s.length();

        for (int i = 1; i <= n / 2; i++) {
            String str = s.substring(0, i);
            boolean flag = true;
            int len = str.length();

            for (int j = 0; j < n; j += len) {
                int end = Math.min(n, j + len);
                if (!str.equals(s.substring(j, end))) {
                    flag = false;
                    break;
                }

            }
            if (flag) {
                return true;
            }

        }

        return false;
    }

    // 好离谱的解
    // 执行耗时:82 ms,击败了38.63% 的Java用户
    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }


}
// leetcode submit region end(Prohibit modification and deletion)
