// 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
//
//
//
//
//
//
//
// 示例 1：
//
//
// 输入：head = [1,2,3,4,5]
// 输出：[5,4,3,2,1]
//
//
// 示例 2：
//
//
// 输入：head = [1,2]
// 输出：[2,1]
//
//
// 示例 3：
//
//
// 输入：head = []
// 输出：[]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目范围是 [0, 5000]
// -5000 <= Node.val <= 5000
//
//
//
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
//
// Related Topics 递归 链表 👍 3495 👎 0


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

    // 依次翻转
    public ListNode reverseList1(ListNode head)
    {
        ListNode p1 = null;
        ListNode p2 = head;

        ListNode temp = head;
        while (p2 != null)
        {
            temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }

        return p1;
    }

    // 依次翻转 的 优化
    public ListNode reverseList2(ListNode head)
    {
        ListNode prev = null;
        ListNode p = head;
        while (p != null)
        {
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }

        return prev;

    }

    // 逆序 递归
    public ListNode reverseList3(ListNode p)
    {
        if (p == null || p.next == null)
        {
            return p;
        }

        ListNode newHead = reverseList(p.next);
        p.next.next = p;
        p.next = null;
        return newHead;

    }

}
// leetcode submit region end(Prohibit modification and deletion)
