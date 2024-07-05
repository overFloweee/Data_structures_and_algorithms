// 给定一个字符串 s ，请你找出其中不含有重复字符的 最长连续子字符串 的长度。
//
//
//
// 示例 1:
//
//
// 输入: s = "abcabcbb"
// 输出: 3
// 解释: 因为无重复字符的最长子字符串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
//
// 输入: s = "bbbbb"
// 输出: 1
// 解释: 因为无重复字符的最长子字符串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
//
// 输入: s = "pwwkew"
// 输出: 3
// 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
//
// 示例 4:
//
//
// 输入: s = ""
// 输出: 0
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 5 * 10⁴
// s 由英文字母、数字、符号和空格组成
//
//
//
//
//
// 注意：本题与主站 3 题相同： https://leetcode-cn.com/problems/longest-substring-without-
// repeating-characters/
//
// Related Topics 哈希表 字符串 滑动窗口 👍 110 👎 0


// leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int lengthOfLongestSubstring(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        char[] arr = s.toCharArray();
        int n = s.length();
        int max = 0;
        for (int j = 0; j < n; j++) {
            // 包含，则出队列
            while (deque.contains(arr[j])) {
                deque.removeFirst();
            }
            deque.addLast(arr[j]);
            max = Integer.max(max, deque.size());
        }

        return max;
    }

    // 最优解
    public int lengthOfLongestSubstring2(String s) {
        char[] arr = s.toCharArray();
        int n = s.length();
        boolean[] has = new boolean[128];
        int i = 0;
        int max = 0;
        for (int j = 0; j < n; j++) {
            char c = arr[j];

            // 存在该字符
            while (has[c]) {
                // 则从头依次剔除
                has[arr[i++]] = false;
            }
            has[c] = true;
            max = Integer.max(max, j - i + 1);
        }

        return max;
    }
}
// leetcode submit region end(Prohibit modification and deletion)
