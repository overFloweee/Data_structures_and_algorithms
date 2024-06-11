// 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
//
//
// 如果剩余字符少于 k 个，则将剩余字符全部反转。
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
//
//
//
//
// 示例 1：
//
//
// 输入：s = "abcdefg", k = 2
// 输出："bacdfeg"
//
//
// 示例 2：
//
//
// 输入：s = "abcd", k = 2
// 输出："bacd"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 10⁴
// s 仅由小写英文组成
// 1 <= k <= 10⁴
//
//
// Related Topics 双指针 字符串 👍 598 👎 0


// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 初解 滑动窗口
    public String reverseStr(String s, int k) {
        int i = 0;
        int n = s.length();
        char[] arr = s.toCharArray();

        for (int j = 0; j < n; ++j) {
            int flag = j - i + 1;
            if (flag == 2 * k) {
                subReverse(arr, k, i);
                i = j + 1;
            }
            else if (j == n - 1 && flag >= k) {
                subReverse(arr, k, i);
            }
            else if (j == n - 1 && flag < k) {
                subReverse(arr, flag, i);
            }
        }
        return new String(arr);
    }

    public static void subReverse(char[] arr, int num, int pre) {
        int start = pre;
        int end = pre + num - 1;
        while (start < end) {
            // 交换 start 和 end 指向的元素
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public String reverseStr2(String s, int k) {
        char[] arr = s.toCharArray();
        int n = s.length();
        for (int l = 0; l < n; l = l + 2 * k) {
            int r = l + k - 1;
            reverse(arr, l, Math.min(r, n - 1));
        }

        return new String(arr);
    }

    public static void reverse(char[] arr, int start, int end) {
        while (start < end) {
            // 交换 start 和 end 指向的元素
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
// leetcode submit region end(Prohibit modification and deletion)
