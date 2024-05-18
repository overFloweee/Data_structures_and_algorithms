// 给定一个字符串
// s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
//
//
//
// 示例 1：
//
//
// 输入：s = "Let's take LeetCode contest"
// 输出："s'teL ekat edoCteeL tsetnoc"
//
//
// 示例 2:
//
//
// 输入： s = "Mr Ding"
// 输出："rM gniD"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 5 * 10⁴
//
// s 包含可打印的 ASCII 字符。
//
// s 不包含任何开头或结尾空格。
//
// s 里 至少 有一个词。
//
// s 中的所有单词都用一个空格隔开。
//
//
// Related Topics 双指针 字符串 👍 585 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 初解 9ms 30%
    public String reverseWords1(String s) {
        String[] arr = s.split(" ");
        int arrN = arr.length;
        for (int i = 0; i < arrN; i++) {
            StringBuilder sb = new StringBuilder();
            String str = arr[i];
            int n = str.length();
            for (int j = n - 1; j >= 0; j--) {
                sb.append(str.charAt(j));
            }
            arr[i] = sb.toString();
        }

        return String.join(" ", arr);
    }

    // 5ms 55.8%
    public String reverseWords2(String s) {
        String[] split = s.split(" ");
        int n = split.length;
        for (int i = 0; i < n; i++) {
            split[i] = new StringBuffer(split[i]).reverse().toString();
        }
        return String.join(" ", split);
    }

    // 3ms 88%
    public String reverseWords4(String s) {
        StringBuilder sb = new StringBuilder();
        String[] split = s.split(" ");
        for (String p : split) {
            sb.append(new StringBuilder(p).reverse());
            sb.append(" ");
        }

        return sb.substring(0, sb.length() - 1).toString();
    }

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split(" ");
        for (String p : arr) {
            sb.append(new StringBuilder(p).reverse());
            sb.append(" ");
        }

        // return sb.toString().substring(0, s.length());
        return sb.substring(0, sb.length() - 1).toString();

    }

}
// leetcode submit region end(Prohibit modification and deletion)
