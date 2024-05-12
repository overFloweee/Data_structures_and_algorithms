// 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
// 如果 needle 不是 haystack 的一部分，则返回 -1 。
//
//
//
// 示例 1：
//
//
// 输入：haystack = "sadbutsad", needle = "sad"
// 输出：0
// 解释："sad" 在下标 0 和 6 处匹配。
// 第一个匹配项的下标是 0 ，所以返回 0 。
//
//
// 示例 2：
//
//
// 输入：haystack = "leetcode", needle = "leeto"
// 输出：-1
// 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
//
//
//
//
// 提示：
//
//
// 1 <= haystack.length, needle.length <= 10⁴
// haystack 和 needle 仅由小写英文字符组成
//
//
// Related Topics 双指针 字符串 字符串匹配 👍 2215 👎 0


// leetcode submit region begin(Prohibit modification and deletion)

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    // 正则
    public int strStr1(String haystack, String needle) {
        Pattern pattern = Pattern.compile(needle);
        Matcher matcher = pattern.matcher(haystack);
        if (matcher.find()) {
            int start = matcher.start();
            return start;
        }
        return -1;
    }

    public int strStr2(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    // 初解
    public int strStr3(String haystack, String needle) {
        int n = haystack.length();
        int len = needle.length();
        for (int i = 0; i < n; i++) {
            int size = 0;
            int temp = i;
            while (haystack.charAt(temp) == needle.charAt(size)) {

                if (len == size + 1) {
                    return temp - size;
                }
                if (n == temp + 1) {
                    return -1;
                }
                size++;
                temp++;
            }
        }

        return -1;
    }

    // 官解
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int len = needle.length();

        for (int i = 0; i + len <= n; i++) {
            boolean f = true;
            for (int j = 0; j < len; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    f = false;
                    break;
                }
            }
            if (f) {
                return i;
            }
        }

        return -1;
    }


}
// leetcode submit region end(Prohibit modification and deletion)
