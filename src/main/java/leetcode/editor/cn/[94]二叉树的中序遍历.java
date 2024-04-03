// 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
//
//
//
// 示例 1：
//
//
// 输入：root = [1,null,2,3]
// 输出：[1,3,2]
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
// 树中节点数目在范围 [0, 100] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 2034 👎 0


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
    public List<Integer> inorderTraversal1(TreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        midOrder(list, root);
        return list;
    }

    public static void midOrder(List<Integer> list, TreeNode node)
    {
        if (node == null)
        {
            return;
        }
        midOrder(list, node.left);
        list.add(node.val);
        midOrder(list, node.right);

    }


    // 非递归实现 - 妙法
    public List<Integer> inorderTraversal2(TreeNode root)
    {
        LinkedList<TreeNode> stack = new LinkedList<>();

        ArrayList<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null)
        {
            if (cur != null)
            {
                stack.push(cur);
                cur = cur.left;
            }
            else
            {
                TreeNode pop = stack.pop();
                list.add(pop.val);
                cur = pop.right;
            }
        }

        return list;

    }
}
// leetcode submit region end(Prohibit modification and deletion)
