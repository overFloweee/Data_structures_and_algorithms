// 给定两个字符串 s 和 t ，判断它们是否是同构的。
//
// 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
//
// 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
//
//
//
// 示例 1:
//
//
// 输入：s = "egg", t = "add"
// 输出：true
//
//
// 示例 2：
//
//
// 输入：s = "foo", t = "bar"
// 输出：false
//
// 示例 3：
//
//
// 输入：s = "paper", t = "title"
// 输出：true
//
//
//
// 提示：
//
//
//
//
//
// 1 <= s.length <= 5 * 10⁴
// t.length == s.length
// s 和 t 由任意有效的 ASCII 字符组成
//
//
// Related Topics 哈希表 字符串 👍 719 👎 0


import java.util.HashMap;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isIsomorphic1(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        if (n1 != n2) {
            return false;
        }

        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < n1; i++) {
            char c = s.charAt(i);
            char c1 = t.charAt(i);
            if (map1.containsKey(c) && map1.get(c) != c1) {
                return false;
            }
            if (map2.containsKey(c1) && map2.get(c1) != c) {
                return false;
            }
            map1.put(c, c1);
            map2.put(c1, c);
        }

        return true;
    }

    public boolean isIsomorphic(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))) {
                return false;
            }
        }
        return true;

    }


}
// leetcode submit region end(Prohibit modification and deletion)
