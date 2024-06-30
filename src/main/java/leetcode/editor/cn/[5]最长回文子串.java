// 给你一个字符串 s，找到 s 中最长的回文子串。
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
//
//
//
// 示例 1：
//
//
// 输入：s = "babad"
// 输出："bab"
// 解释："aba" 同样是符合题意的答案。
//
//
// 示例 2：
//
//
// 输入：s = "cbbd"
// 输出："bb"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 仅由数字和英文字母组成
//
//
// Related Topics 双指针 字符串 动态规划 👍 7200 👎 0


import java.util.Arrays;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 初解：解不出来
    public String longestPalindrome1(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;

        for (int i = 1; i < n; i++) {
            dp[i][i] = true;
        }

        String t = "";
        for (int i = 0; i < n; i++) {
            // i + j + 1 < n
            for (int j = i + 1; j < n - i - 1; j++) {
                if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    t = s.substring(i, j + 1);
                }
            }
        }


        return t;
    }

    // ai相似解
    public String longestPalindrome2(String s) {
        int n = s.length();
        if (n == 0) {
            return "";
        }

        boolean[][] dp = new boolean[n][n];
        String res = "";

        // 初始化单个字符为回文
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            res = s.substring(i, i + 1);
        }

        // 长度为2的字符串检查
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                res = s.substring(i, i + 2);
            }
        }

        // 从长度为3开始，检查每个可能的子串
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (len > res.length()) {
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }

        return res;
    }

    // 二刷
    // 中心扩散法
    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(0);

        char[] arr = s.toCharArray();
        int n = arr.length;

        // 当回文子串为奇数时
        for (int cur = 0; cur < n; cur++) {
            int i = cur;
            int j = cur;
            while (i >= 0 && j < n && arr[i] == arr[j]) {
                i--;
                j++;
            }
            // 此时不是回文串，需要回退一次
            i++;
            j--;

            int len = j - i + 1;
            if (len > sb.length()) {
                sb = new StringBuilder(s.substring(i, j + 1));
            }
        }

        // 当回文子串为偶数时
        for (int cur = 1; cur < n; cur++) {
            if (arr[cur] == arr[cur - 1]) {
                int i = cur;
                int j = cur - 1;
                while (i >= 0 && j < n && arr[i] == arr[j]) {
                    i--;
                    j++;
                }
                // 此时不是回文串，需要回退一次
                i++;
                j--;

                int len = j - i + 1;
                if (len > sb.length()) {
                    sb = new StringBuilder(s.substring(i, j + 1));
                }
            }
        }

        return sb.toString();
    }

}
// leetcode submit region end(Prohibit modification and deletion)
