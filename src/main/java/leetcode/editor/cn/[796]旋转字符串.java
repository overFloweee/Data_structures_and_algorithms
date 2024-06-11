// 给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。
//
// s 的 旋转操作 就是将 s 最左边的字符移动到最右边。
//
//
// 例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。
//
//
//
//
// 示例 1:
//
//
// 输入: s = "abcde", goal = "cdeab"
// 输出: true
//
//
// 示例 2:
//
//
// 输入: s = "abcde", goal = "abced"
// 输出: false
//
//
//
//
// 提示:
//
//
// 1 <= s.length, goal.length <= 100
// s 和 goal 由小写英文字母组成
//
//
// Related Topics 字符串 字符串匹配 👍 313 👎 0


// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 旋转字符串
    public boolean rotateString(String s, String goal) {
        int n1 = s.length();
        int n2 = goal.length();
        if (n1 != n2) {
            return false;
        }

        String str = s;
        for (int i = 0; i < n1; i++) {
            str = xuanzhuan(str, 1);
            if (str.equals(goal)) {
                return true;
            }
        }


        return false;
    }

    public static String xuanzhuan(String s, int k) {
        int n = s.length();

        StringBuilder sb = new StringBuilder();
        for (int i = n - k; i < n; i++) {
            sb.append(s.charAt(i));
        }
        for (int i = 0; i < n - k; i++) {
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
// leetcode submit region end(Prohibit modification and deletion)
