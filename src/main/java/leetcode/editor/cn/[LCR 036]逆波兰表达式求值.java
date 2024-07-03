// 根据 逆波兰表示法，求该后缀表达式的计算结果。
//
// 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
//
//
//
// 说明：
//
//
// 整数除法只保留整数部分。
// 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
//
//
//
//
// 示例 1：
//
//
// 输入：tokens = ["2","1","+","3","*"]
// 输出：9
// 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
//
//
// 示例 2：
//
//
// 输入：tokens = ["4","13","5","/","+"]
// 输出：6
// 解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
//
//
// 示例 3：
//
//
// 输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
// 输出：22
// 解释：
// 该算式转化为常见的中缀算术表达式为：
//  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
//= ((10 * (6 / (12 * -11))) + 17) + 5
//= ((10 * (6 / -132)) + 17) + 5
//= ((10 * 0) + 17) + 5
//= (0 + 17) + 5
//= 17 + 5
//= 22
//
//
//
// 提示：
//
//
// 1 <= tokens.length <= 10⁴
// tokens[i] 要么是一个算符（"+"、"-"、"*" 或 "/"），要么是一个在范围 [-200, 200] 内的整数
//
//
//
//
// 逆波兰表达式：
//
// 逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。
//
//
// 平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。
// 该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。
//
//
// 逆波兰表达式主要有以下两个优点：
//
//
// 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
// 适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中。
//
//
//
//
//
// 注意：本题与主站 150 题相同： https://leetcode-cn.com/problems/evaluate-reverse-polish-
// notation/
//
// Related Topics 栈 数组 数学 👍 58 👎 0


import java.util.Stack;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();


        for (String token : tokens) {
            switch (token) {
                case "+" -> {
                    int a1 = stack.pop();
                    int a2 = stack.pop();
                    stack.push(a2 + a1);
                }
                case "-" -> {
                    int a1 = stack.pop();
                    int a2 = stack.pop();
                    stack.push(a2 - a1);
                }
                case "*" -> {
                    int a1 = stack.pop();
                    int a2 = stack.pop();
                    stack.push(a2 * a1);
                }
                case "/" -> {
                    int a1 = stack.pop();
                    int a2 = stack.pop();
                    stack.push(a2 / a1);
                }
                default -> {
                    stack.push(Integer.parseInt(token));
                }
            }
        }
        return stack.pop();
    }

    public int evalRPN2(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        int sum = 0;
        for (String token : tokens) {
            if ("+".equals(token)) {
                stack.push(stack.pop() + stack.pop());
            }
            else if ("-".equals(token)) {
                Integer pop1 = stack.pop();
                Integer pop2 = stack.pop();
                stack.push(pop2 - pop1);
            }
            else if ("*".equals(token)) {
                stack.push(stack.pop() * stack.pop());
            }
            else if ("/".equals(token)) {
                Integer pop1 = stack.pop();
                Integer pop2 = stack.pop();
                stack.push(pop2 / pop1);
            }
            else {
                stack.push(Integer.valueOf(token));
            }

        }

        return stack.peek();
    }
}
// leetcode submit region end(Prohibit modification and deletion)
