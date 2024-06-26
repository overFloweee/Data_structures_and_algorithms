// 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
//
//
//
// 示例 1：
//
//
// 输入：head = [1,2,3,4]
// 输出：[2,1,4,3]
//
//
// 示例 2：
//
//
// 输入：head = []
// 输出：[]
//
//
// 示例 3：
//
//
// 输入：head = [1]
// 输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 100] 内
// 0 <= Node.val <= 100
//
//
// Related Topics 递归 链表 👍 2142 👎 0


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
class Solution {
    public ListNode swapPairs1(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode sentinel = new ListNode(-1, head);
        ListNode p1 = sentinel;
        ListNode p2 = sentinel.next;
        ListNode temp;

        while (p2.next != null) {
            temp = p2.next;
            p2.next = temp.next;
            temp.next = p2;
            p1.next = temp;

            if (p2.next == null) {
                break;
            }
            p1 = p2;
            p2 = p2.next;
        }

        return sentinel.next;
    }

    // * 递归
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

    // 二刷
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dump = new ListNode(0, head);


        ListNode l = head;
        ListNode r = head.next;
        ListNode prev = dump;
        ListNode next = null;

        while (r != null) {
            next = r.next;
            r.next = l;
            l.next = next;
            prev.next = r;

            prev = l;
            l = next;
            if (l == null) {
                break;
            }
            r = l.next;
        }
        return dump.next;
    }
}
// leetcode submit region end(Prohibit modification and deletion)
