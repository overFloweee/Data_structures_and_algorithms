// 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
// 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
//
//
//
// 示例 1:
//
//
// 输入: s = "anagram", t = "nagaram"
// 输出: true
//
//
// 示例 2:
//
//
// 输入: s = "rat", t = "car"
// 输出: false
//
//
//
// 提示:
//
//
// 1 <= s.length, t.length <= 5 * 10⁴
// s 和 t 仅包含小写字母
//
//
//
//
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
//
// Related Topics 哈希表 字符串 排序 👍 921 👎 0


import java.util.Arrays;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 排序 + 比较
    public boolean isAnagram(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        if (n1 != n2) {
            return false;
        }

        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);


        for (int i = 0; i < n1; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }


    public boolean isAnagram2(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        if (n1 != n2) {
            return false;
        }

        int[] table = new int[26];
        for (int i = 0; i < n1; i++) {
            table[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < n2; i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
// leetcode submit region end(Prohibit modification and deletion)
