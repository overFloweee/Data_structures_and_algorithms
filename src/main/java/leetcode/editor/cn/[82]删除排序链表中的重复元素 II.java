// 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
//
//
//
// 示例 1：
//
//
// 输入：head = [1,2,3,3,4,4,5]
// 输出：[1,2,5]
//
//
// 示例 2：
//
//
// 输入：head = [1,1,1,2,3]
// 输出：[2,3]
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
// Related Topics 链表 双指针 👍 1270 👎 0


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
    // 迭代
    public ListNode deleteDuplicates1(ListNode head)
    {
        if (head == null)
        {
            return head;
        }
        ListNode sentinel = new ListNode(-1, head);

        ListNode p1 = sentinel;
        ListNode p2 = sentinel.next;
        ListNode p3 = head.next;

        boolean flag = false;
        while (p2.next != null)
        {

            if (p2.val == p3.val)
            {
                p2.next = p3.next;
                p3 = p3.next;
                flag = true;
            }
            else
            {
                if (flag == true)
                {
                    p1.next = p2.next;
                    flag = false;
                }
                else
                {
                    p1 = p1.next;
                }
                p2 = p2.next;
                p3 = p3.next;
            }
        }

        if (flag == true)
        {
            p1.next = p2.next;
        }

        return sentinel.next;

    }


    public ListNode deleteDuplicates(ListNode head)
    {
        if (head == null)
        {
            return head;
        }

        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null)
        {
            if (cur.next.val == cur.next.next.val)
            {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x)
                {
                    cur.next = cur.next.next;
                }
            }
            else
            {
                cur = cur.next;
            }
        }

        return dummy.next;

    }
}
// leetcode submit region end(Prohibit modification and deletion)
