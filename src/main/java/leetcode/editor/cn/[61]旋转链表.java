// 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
//
//
//
// 示例 1：
//
//
// 输入：head = [1,2,3,4,5], k = 2
// 输出：[4,5,1,2,3]
//
//
// 示例 2：
//
//
// 输入：head = [0,1,2], k = 4
// 输出：[2,0,1]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 500] 内
// -100 <= Node.val <= 100
// 0 <= k <= 2 * 10⁹
//
//
// Related Topics 链表 双指针 👍 1053 👎 0


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
    // 初解 - 没解出来
    public ListNode rotateRight1(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        ListNode p = head;
        // 这里有问题
        for (int i = 0; i < k; i++) {
            p = p.next;
            if (p == null) {
                p = head;
            }
        }

        ListNode last = p;

        while (last.next != null) {
            last = last.next;
        }
        ListNode newHead = p.next;
        p.next = null;
        last.next = head;


        return newHead;
    }

    public ListNode rotateRight2(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }
        int add = n - k % n;
        if (add == n) {
            return head;
        }
        iter.next = head;
        while (add-- > 0) {
            iter = iter.next;
        }
        ListNode ret = iter.next;
        iter.next = null;
        return ret;
    }
    // 优化解
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0)
        {
            return head;
        }

        ListNode tail = head;
        int n = 1;
        while (tail.next != null)
        {
            tail = tail.next;
            n++;
        }

        ListNode p = head;
        k = k % n;

        // 这里是要找到第 n - k个节点，不是之前以为的第k个
        for(int i = 0; i < n - k - 1; ++i)
        {
            p = p.next;
        }

        // 成环
        tail.next = head;
        head = p.next;
        p.next = null;

        return head;
    }


}
// leetcode submit region end(Prohibit modification and deletion)
