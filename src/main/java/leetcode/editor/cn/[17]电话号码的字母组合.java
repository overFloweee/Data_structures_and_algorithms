//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
//
//
// 示例 1：
//
//
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
//
//
// 示例 2：
//
//
//输入：digits = ""
//输出：[]
//
//
// 示例 3：
//
//
//输入：digits = "2"
//输出：["a","b","c"]
//
//
//
//
// 提示：
//
//
// 0 <= digits.length <= 4
// digits[i] 是范围 ['2', '9'] 的一个数字。
//
//
// Related Topics 哈希表 字符串 回溯 👍 2849 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""
    String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    StringBuilder path = new StringBuilder();
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }

        char[] arr = digits.toCharArray();
        // 字符串数组的索引
        int index = 0;
        method(arr, index);

        return res;
    }

    public void method(char[] arr, int index) {
        if (path.length() == arr.length) {
            res.add(path.toString());
            return;
        }

        String str = numString[arr[index] - '0'];
        for (int i = 0; i < str.length(); i++) {
            path.append(str.charAt(i));
            method(arr, index + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
