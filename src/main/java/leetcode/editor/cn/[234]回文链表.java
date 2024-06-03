//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,2,1]
//输出：true
//
//
// 示例 2：
//
//
//输入：head = [1,2]
//输出：false
//
//
//
//
// 提示：
//
//
// 链表中节点数目在范围[1, 10⁵] 内
// 0 <= Node.val <= 9
//
//
//
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
//
// Related Topics 栈 递归 链表 双指针 👍 1906 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // 初解
    public boolean isPalindrome(ListNode head) {

        ListNode dump = new ListNode(0, head);
        ListNode p1 = dump;
        ListNode p2 = dump;
        // 获取中间节点
        while (p2 != null && p2.next != null)
        {

            p1 = p1.next;
            p2 = p2.next.next;
        }

        // 反转后半部分链表
        ListNode l = null;
        ListNode mid = p1.next;
        while (mid != null)
        {
            ListNode temp = mid.next;
            mid.next = l;
            l = mid;
            mid = temp;
        }

        // 与前半部分链表作比较
        while (l != null)
        {
            if (l.val != head.val)
            {
                return false;
            }
            l = l.next;
            head = head.next;
        }

        return true;
    }

    // 官解
    public boolean isPalindrome(ListNode head) {
        ListNode p1 = head;// 慢
        ListNode p2 = head;// 快
        ListNode n1 = null;// 新头
        ListNode o1 = head;// 旧头
        while (p2 != null && p2.next != null)
        {
            p1 = p1.next;
            p2 = p2.next.next;
            // 反转链表
            o1.next = n1;
            n1 = o1;
            o1 = p1;
        }
        if (p2 != null)
        {
            p1 = p1.next;
        }
        while (n1 != null)
        {
            if (n1.val != p1.val)
            {
                return false;
            }
            n1 = n1.next;
            p1 = p1.next;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
