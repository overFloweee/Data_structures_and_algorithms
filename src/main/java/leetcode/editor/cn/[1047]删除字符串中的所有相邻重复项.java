// 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
//
// 在 S 上反复执行重复项删除操作，直到无法继续删除。
//
// 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
//
//
//
// 示例：
//
// 输入："abbaca"
// 输出："ca"
// 解释：
// 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又
// 只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
//
//
//
//
// 提示：
//
//
// 1 <= S.length <= 20000
// S 仅由小写英文字母组成。
//
//
// Related Topics 栈 字符串 👍 634 👎 0


import java.util.Stack;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 初解
    public String removeDuplicates(String s) {
        char[] arr = s.toCharArray();

        Stack<Character> stack = new Stack<>();
        // LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < arr.length; ++i) {
            if (!stack.isEmpty() && stack.peek() == arr[i]) {
                stack.pop();
            }
            else {
                stack.push(arr[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }

    // 直接使用StringBuilder当成栈使用，不过需要额外维护一个top指针代表当前栈顶元素
    public String removeDuplicates2(String s) {
        char[] arr = s.toCharArray();

        StringBuilder stack = new StringBuilder();
        int top = -1;
        for (int i = 0; i < arr.length; i++) {
            if (top >= 0 && stack.charAt(top) == arr[i]) {
                stack.deleteCharAt(top);
                top--;
            }
            else {
                stack.append(arr[i]);
                top++;
            }
        }

        return stack.toString();

    }

    // 思路非常优秀的解
    public String removeDuplicates4(String S) {
        char[] s = S.toCharArray();
        int top = -1;
        for (int i = 0; i < S.length(); i++) {
            if (top == -1 || s[top] != s[i]) {
                s[++top] = s[i];
            }
            else {
                top--;
            }
        }
        return String.valueOf(s, 0, top + 1);
    }
}
// leetcode submit region end(Prohibit modification and deletion)
