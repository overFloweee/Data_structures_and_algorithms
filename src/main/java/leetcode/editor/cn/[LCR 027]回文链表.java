// 给定一个链表的 头节点 head ，请判断其是否为回文链表。
//
// 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。
//
//
//
// 示例 1：
//
//
//
//
// 输入: head = [1,2,3,3,2,1]
// 输出: true
//
// 示例 2：
//
//
//
//
// 输入: head = [1,2]
// 输出: false
//
//
//
//
// 提示：
//
//
// 链表 L 的长度范围为 [1, 10⁵]
// 0 <= node.val <= 9
//
//
//
//
// 进阶：能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
//
//
//
//
// 注意：本题与主站 234 题相同：https://leetcode-cn.com/problems/palindrome-linked-list/
//
// Related Topics 栈 递归 链表 双指针 👍 131 👎 0


// leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution
{
    public boolean isPalindrome1(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return true;
        }

        // 快慢指针
        ListNode p1 = head;
        ListNode p2 = head;

        ListNode temp = null;
        ListNode left = null;
        ListNode right = head;

        while (p2 != null && p2.next != null)
        {
            p1 = p1.next;
            p2 = p2.next.next;

            // 翻转前半部分链表
            temp = right.next;
            right.next = left;
            left = right;
            right = temp;
        }

        // 奇数个节点情况
        if (p2 != null)
        {
            p1 = p1.next;
        }

        while (p1 != null)
        {
            if (p1.val != left.val)
            {
                return false;
            }
            p1 = p1.next;
            left = left.next;
        }

        return true;
    }

    // 优化
    public boolean isPalindrome(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return true;
        }

        // 快慢指针
        ListNode p1 = head;
        ListNode p2 = head;

        ListNode left = null;
        ListNode right = head;

        while (p2 != null && p2.next != null)
        {
            p1 = p1.next;
            p2 = p2.next.next;

            // 翻转前半部分链表
            right.next = left;
            left = right;
            right = p1;
        }

        // 奇数个节点情况
        if (p2 != null)
        {
            p1 = p1.next;
        }

        while (p1 != null)
        {
            if (p1.val != left.val)
            {
                return false;
            }
            p1 = p1.next;
            left = left.next;
        }

        return true;
    }
}
// leetcode submit region end(Prohibit modification and deletion)
