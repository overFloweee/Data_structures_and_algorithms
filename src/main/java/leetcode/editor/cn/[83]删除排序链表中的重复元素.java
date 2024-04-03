// 给定一个已排序的链表的头
// head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
//
//
//
// 示例 1：
//
//
// 输入：head = [1,1,2]
// 输出：[1,2]
//
//
// 示例 2：
//
//
// 输入：head = [1,1,2,3,3]
// 输出：[1,2,3]
//
//
//
//
// 提示：
//
//
// 链表中节点数目在范围 [0, 300] 内
// -100 <= Node.val <= 100
// 题目数据保证链表已经按升序 排列
//
//
// Related Topics 链表 👍 1104 👎 0


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
    public ListNode deleteDuplicates1(ListNode head)
    {
        if (head == null)
        {
            return head;
        }

        ListNode p1 = head;
        ListNode p2 = p1.next;
        while (p2 != null)
        {
            if (p1.val == p2.val)
            {
                p1.next = p2.next;
                p2 = p2.next;
            }
            else
            {
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return head;
    }

    // 递归
    public ListNode deleteDuplicates2(ListNode head)
    {

        if (head == null || head.next == null)
        {
            return head;
        }

        if (head.val == head.next.val)
        {
            head.next = deleteDuplicates(head.next);
            return head.next;
        }
        else
        {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }

    // 递归
    public ListNode deleteDuplicates(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }

        if (head.val == head.next.val)
        {
            head.next = deleteDuplicates(head.next);
            return head.next;
        }
        else
        {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }
}
// leetcode submit region end(Prohibit modification and deletion)
