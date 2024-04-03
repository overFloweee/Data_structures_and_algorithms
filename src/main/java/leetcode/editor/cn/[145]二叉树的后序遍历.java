// 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
//
//
//
// 示例 1：
//
//
// 输入：root = [1,null,2,3]
// 输出：[3,2,1]
//
//
// 示例 2：
//
//
// 输入：root = []
// 输出：[]
//
//
// 示例 3：
//
//
// 输入：root = [1]
// 输出：[1]
//
//
//
//
// 提示：
//
//
// 树中节点的数目在范围 [0, 100] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1166 👎 0


// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution
{
    // 递归实现
    public List<Integer> postorderTraversal1(TreeNode root)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
        {
            return list;
        }

        postOrder(list, root);
        return list;
    }

    public static void postOrder(List<Integer> list, TreeNode node)
    {
        if (node == null)
        {
            return;
        }
        postOrder(list, node.left);
        postOrder(list, node.right);
        list.add(node.val);
    }

    // 非递归实现
    public List<Integer> postorderTraversal2(TreeNode root)
    {
        LinkedList<TreeNode> stack = new LinkedList<>();

        ArrayList<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        TreeNode pop = null;

        while (!stack.isEmpty() || cur != null)
        {
            if (cur != null)
            {
                stack.push(cur);
                cur = cur.left;
            }
            else
            {
                TreeNode peek = stack.peek();
                if (peek.right == null || peek.right == pop)
                {
                    pop = stack.pop();
                    list.add(pop.val);
                }
                else
                {
                    cur = peek.right;
                }
            }
        }

        return list;
    }


    // 非递归实现 - 妙法
    public List<Integer> postorderTraversal(TreeNode root)
    {

        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        LinkedList<TreeNode> stack1 = new LinkedList<>();
        LinkedList<TreeNode> stack2 = new LinkedList<>();
        stack1.push(root);


        while (!stack1.isEmpty())
        {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left != null)
            {
                stack1.push(node.left);
            }
            if (node.right != null)
            {
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty())
        {
            list.add(stack2.pop().val);
        }
        return list;
    }
}
// leetcode submit region end(Prohibit modification and deletion)
