package exam1;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Main {

    // 结果存储列表
    static List<Integer> result = new ArrayList<>();

    // 特定的修剪遍历（先左子树所有节点，再处理右子树）
    public static void pruneTree(TreeNode node) {
        if (node == null) {
            return;
        }
        result.add(node.val);  // 访问当前节点
        pruneLeftSubtree(node.left);  // 先递归处理左子树的所有节点
        pruneRightSubtree(node.right); // 再递归处理右子树
    }


    // 遍历并修剪左子树
    public static void pruneLeftSubtree(TreeNode node) {
        if (node == null) {
            return;
        }
        result.add(node.val);  // 访问当前左子树节点
        pruneLeftSubtree(node.left);  // 递归处理左子树
        pruneLeftSubtree(node.right); // 递归处理右子树

        ArrayList<Object> list = new ArrayList<>();
        LinkedList<Object> objects = new LinkedList<>();
        // objects.add()

    }

    // 遍历并修剪右子树
    public static void pruneRightSubtree(TreeNode node) {
        if (node == null) {
            return;
        }
        pruneRightSubtree(node.left);  // 先递归处理右子树的左节点
        result.add(node.val);  // 然后访问当前右子树节点
        pruneRightSubtree(node.right); // 最后递归处理右子树的右节点
    }

    // 构建二叉树，处理层序遍历的输入，包括空节点
    public static TreeNode buildTree(String[] values) {
        if (values.length == 0 || values[0].equals("#")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();

            // 构建左子树
            if (!values[i].equals("#")) {
                current.left = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(current.left);
            }
            i++;

            // 构建右子树
            if (i < values.length && !values[i].equals("#")) {
                current.right = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入
        String input = scanner.nextLine();  // 输入层序遍历的字符串
        input = input.replaceAll("[{}]", ""); // 移除大括号
        String[] values = input.split(","); // 分割成字符串数组

        // 构建二叉树
        TreeNode root = buildTree(values);

        // 修剪并输出
        pruneTree(root);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i != result.size() - 1) {
                System.out.print(" ");
            }
        }
    }
}
