// 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
// 每个右括号都有一个对应的相同类型的左括号。
//
//
//
//
// 示例 1：
//
//
// 输入：s = "()"
// 输出：true
//
//
// 示例 2：
//
//
// 输入：s = "()[]{}"
// 输出：true
//
//
// 示例 3：
//
//
// 输入：s = "(]"
// 输出：false
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 10⁴
// s 仅由括号 '()[]{}' 组成
//
//
// Related Topics 栈 字符串 👍 4341 👎 0


import java.util.Stack;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution
{
    public boolean isValid(String s)
    {

        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++)
        {
            char c = s.charAt(i);
            if (c == '(')
            {
                stack.push(')');
            }
            else if (c == '[')
            {
                stack.push(']');
            }
            else if (c == '{')
            {
                stack.push('}');
            }
            else
            {

                if (!stack.isEmpty() && stack.peek() == c)
                {
                    stack.pop();
                }
                else
                {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
// leetcode submit region end(Prohibit modification and deletion)
