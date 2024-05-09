// 编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
//
//
// 示例 1：
//
//
// 输入：strs = ["flower","flow","flight"]
// 输出："fl"
//
//
// 示例 2：
//
//
// 输入：strs = ["dog","racecar","car"]
// 输出：""
// 解释：输入不存在公共前缀。
//
//
//
// 提示：
//
//
// 1 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] 仅由小写英文字母组成
//
//
// Related Topics 字典树 字符串 👍 3118 👎 0



// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 初解：拿到第一个字符串，与后续字符串的该下标元素进行对比
    public String longestCommonPrefix1(String[] strs) {
        int n = strs.length;
        String first = strs[0];
        int len = first.length();
        // 外层是字符串的第几个字符
        for (int i = 0; i < len; i++) {
            char c = first.charAt(i);
            // 内层是判断每个字符串 是否包含上述字符
            for (int j = 1; j < n; j++) {
                if (i > strs[j].length() - 1 || c != strs[j].charAt(i)) {
                    return first.substring(0, i);
                }
            }
        }

        return first;
    }

    // 官解
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }
    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }


    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // 使用Arrays.sort对字符串数组进行排序
        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length - 1];
        int length = Math.min(first.length(), last.length());

        // 遍历第一个和最后一个字符串，比较字符
        for (int i = 0; i < length; i++) {
            if (first.charAt(i) != last.charAt(i)) {
                // 如果不匹配，返回从第一个字符串到i位置的子字符串
                return first.substring(0, i);
            }
        }

        // 如果都匹配，则返回第一个字符串（因为它就是最长的公共前缀）
        return first;
    }

    // LSP(S1,S2)
    public String longestCommonPrefix(String[] strs)
    {
        int n = strs.length;

        String longStr = strs[0];
        for(int i = 1; i < n; ++i)
        {
            longStr = LSP(longStr, strs[i]);
        }

        return longStr;
    }

    public static String LSP(String s1, String s2)
    {
        if (s1.length() > s2.length())
        {
            String temp = s2;
            s2 = s1;
            s1 = temp;
        }

        int n = s1.length();

        for(int i = 0; i < n; ++i)
        {
            if(s1.charAt(i) != s2.charAt(i))
            {
                return s1.substring(0, i);
            }
        }
        return s1;
    }
}
// leetcode submit region end(Prohibit modification and deletion)
