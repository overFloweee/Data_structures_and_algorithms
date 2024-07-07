// 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
//
//
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312"
// 和 "192.168@1.1" 是 无效 IP 地址。
//
//
// 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新
// 排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
//
//
//
// 示例 1：
//
//
// 输入：s = "25525511135"
// 输出：["255.255.11.135","255.255.111.35"]
//
//
// 示例 2：
//
//
// 输入：s = "0000"
// 输出：["0.0.0.0"]
//
//
// 示例 3：
//
//
// 输入：s = "101023"
// 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 20
// s 仅由数字组成
//
//
// Related Topics 字符串 回溯 👍 1425 👎 0


import java.util.ArrayList;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    public List<String> restoreIpAddresses(String s) {
        int index = 0;
        int high = 0;
        backTracking(s, index, high);
        return res;
    }

    public void backTracking(String s, int index, int high) {
        if (high > 4) {
            return;
        }

        new ArrayList<>().remove()

        if (high == 4 && index + 1 > s.length()) {
            res.add(path.substring(1, path.length()));
            return;
        }

        for (int i = index; i < s.length(); ++i) {
            String tempStr = s.substring(index, i + 1);
            if (tempStr.length() > 3) {
                continue;
            }
            long tempNum = Long.valueOf(tempStr);
            if (tempStr.charAt(0) != '0' && tempNum <= 255) {
                path.append(".").append(tempStr);
            }
            else if (tempStr.length() == 1 && tempStr.charAt(0) == '0') {
                path.append(".").append(tempStr);
            }
            else if (tempStr.length() > 1 && tempStr.charAt(0) == '0') {
                continue;
            }
            else {
                continue;
            }

            backTracking(s, i + 1, high + 1);
            path.delete(path.lastIndexOf("."), path.length());
        }

    }

    // 可以校验是否合法
    // 字符串s在左闭⼜闭区间[start, end]所组成的数字是否合法
    private Boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) { // 0开头的数字不合法
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 遇到⾮数字字符不合法
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) { // 如果⼤于255了不合法
                return false;
            }
        }
        return true;
    }
}
// leetcode submit region end(Prohibit modification and deletion)
