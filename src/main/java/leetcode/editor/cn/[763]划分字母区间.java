// 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
//
// 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
//
// 返回一个表示每个字符串片段的长度的列表。
//
//
// 示例 1：
//
//
// 输入：s = "ababcbacadefegdehijhklij"
// 输出：[9,7,8]
// 解释：
// 划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
// 每个字母最多出现在一个片段中。
// 像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。
//
// 示例 2：
//
//
// 输入：s = "eccbbbbdec"
// 输出：[10]
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 500
// s 仅由小写英文字母组成
//
//
// Related Topics 贪心 哈希表 双指针 字符串 👍 1160 👎 0


// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 官解
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        List<Integer> list = new ArrayList<>();
        int[] maxIndex = new int[26];

        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; ++i) {
            maxIndex[arr[i] - 'a'] = i;
        }

        int l = -1;
        int index = 0;
        for (int i = 0; i < arr.length; ++i) {
            index = Math.max(maxIndex[arr[i] - 'a'], index);
            if (index == i) {
                list.add(i - l);
                l = i;
            }
        }

        return list;
    }
}
// leetcode submit region end(Prohibit modification and deletion)
