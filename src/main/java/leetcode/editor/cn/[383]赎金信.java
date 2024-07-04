// 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
//
// 如果可以，返回 true ；否则返回 false 。
//
// magazine 中的每个字符只能在 ransomNote 中使用一次。
//
//
//
// 示例 1：
//
//
// 输入：ransomNote = "a", magazine = "b"
// 输出：false
//
//
// 示例 2：
//
//
// 输入：ransomNote = "aa", magazine = "ab"
// 输出：false
//
//
// 示例 3：
//
//
// 输入：ransomNote = "aa", magazine = "aab"
// 输出：true
//
//
//
//
// 提示：
//
//
// 1 <= ransomNote.length, magazine.length <= 10⁵
// ransomNote 和 magazine 由小写英文字母组成
//
//
// Related Topics 哈希表 字符串 计数 👍 891 👎 0


// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        char[] arr1 = ransomNote.toCharArray();
        char[] arr2 = magazine.toCharArray();


        Map<Character, Integer> map = new HashMap<>();
        for (char i : arr2) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (char c : arr1) {
            if (!map.containsKey(c)) {
                return false;
            }

            int num = map.get(c);
            if (num == 1) {
                map.remove(c);
            }
            else {
                map.put(c, num - 1);
            }

        }

        return true;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];

        char[] charArr1 = ransomNote.toCharArray();
        char[] charArr2 = magazine.toCharArray();

        for(char c : charArr2) {
            arr[c - 'a']++;
        }

        for(char c : charArr1) {
            arr[c - 'a']--;
        }

        for(int i : arr) {
            if (i < 0) {
                return false;
            }
        }

        return true;
    }

}
// leetcode submit region end(Prohibit modification and deletion)
