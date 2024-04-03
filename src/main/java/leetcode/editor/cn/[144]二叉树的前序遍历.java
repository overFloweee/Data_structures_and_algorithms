// 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
//
//
//
// 示例 1：
//
//
// 输入：root = [1,null,2,3]
// 输出：[1,2,3]
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
// 示例 4：
//
//
// 输入：root = [1,2]
// 输出：[1,2]
//
//
// 示例 5：
//
//
// 输入：root = [1,null,2]
// 输出：[1,2]
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [0, 100] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1235 👎 0


// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

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
    public List<Integer> preorderTraversal0(TreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        preOrder(list, root);
        return list;
    }

    public static void preOrder(List<Integer> list, TreeNode node)
    {
        if (node == null)
        {
            return;
        }
        list.add(node.val);
        preOrder(list, node.left);
        preOrder(list, node.right);
    }

    // 非递归实现
    public List<Integer> preorderTraversal1(TreeNode root)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
        {
            return list;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null)
        {
            if (cur == null)
            {
                TreeNode pop = stack.pop();
                cur = pop.right;
            }
            else
            {
                stack.push(cur);
                list.add(cur.val);
                cur = cur.left;
            }

        }
        return list;

    }

    // 非递归实现 - 妙法
    public List<Integer> preorderTraversal(TreeNode root)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
        {
            return list;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty())
        {
            TreeNode pop = stack.pop();
            list.add(pop.val);
            if (pop.right != null)
            {
                stack.push(pop.right);
            }
            if (pop.left != null)
            {
                stack.push(pop.left);
            }

        }
        return list;

    }
}
// leetcode submit region end(Prohibit modification and deletion)
