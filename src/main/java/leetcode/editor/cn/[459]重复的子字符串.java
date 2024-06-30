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
    // 加了一层 if -> 7 ms,击败了82.46% 的Java用户
    public boolean repeatedSubstringPattern1(String s) {
        int n = s.length();
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                String str = s.substring(0, i);
                boolean flag = true;
                for (int j = 0; j < n; j += i) {
                    if (!str.equals(s.substring(j, j + i))) {
                        flag = false;
                        break;
                    }

                }
                if (flag) {
                    return true;
                }

            }

        }

        return false;
    }

    // 初解的优化解
    // 9 ms,击败了75.04% 的Java用户
    public boolean repeatedSubstringPattern2(String s) {
        int n = s.length();
        for (int i = 1; i * 2 <= n; ++i) {
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; ++j) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }

    // 好离谱的解
    // 执行耗时:82 ms,击败了38.63% 的Java用户
    public boolean repeatedSubstringPattern3(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }


    // KMP算法 初解
    // 执行耗时:8 ms,击败了81.03% 的Java用户
    public boolean repeatedSubstringPattern11(String s) {
        String str = s + s;
        return originContainsPartten(str.substring(1, str.length() - 1), s);

    }


    // KMP最优解
    // 4 ms,击败了99.13% 的Java用户
    public boolean repeatedSubstringPattern(String s) {
        int[] next = getPreTable(s.toCharArray());
        int len = s.length();

        // 最后判断是否是重复的子字符串，这里 next[len] 即代表next数组末尾的值
        if (next[len - 1] > 0 && len % (len - next[len - 1]) == 0) {
            return true;
        }
        return false;
    }

    public static boolean originContainsPartten(String s, String parttenStr) {
        char[] origin = s.toCharArray();
        char[] partten = parttenStr.toCharArray();
        int[] preTable = getPreTable(partten);

        int i = 0;
        int j = 0;
        while (partten.length - j <= origin.length - i) {
            if (partten[j] == origin[i]) {
                i++;
                j++;
            }
            else if (j == 0) {
                i++;
            }
            else {
                j = preTable[j - 1];
            }

            if (j == partten.length) {
                return true;
            }
        }

        return false;
    }

    public static int[] getPreTable(char[] partten) {
        int[] arr = new int[partten.length];

        int i = 1;
        int j = 0;
        while (i < partten.length) {
            if (partten[i] == partten[j]) {
                arr[i] = j + 1;
                i++;
                j++;
            }
            else if (j == 0) {
                i++;
            }
            else {
                j = arr[j - 1];
            }
        }

        return arr;
    }


}
// leetcode submit region end(Prohibit modification and deletion)
