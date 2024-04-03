// 编写一个函数，检查输入的链表是否是回文的。
//
//
//
// 示例 1：
//
// 输入： 1->2
// 输出： false
//
//
// 示例 2：
//
// 输入： 1->2->2->1
// 输出： true
//
//
//
//
// 进阶： 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
//
// Related Topics 栈 递归 链表 双指针 👍 136 👎 0


// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution
{
    // 将值复制到数组后，采用双指针
    public boolean isPalindrome1(ListNode head)
    {
        ListNode p = head;
        ArrayList<Integer> list = new ArrayList<>();
        while (p != null)
        {
            list.add(p.val);
            p = p.next;
        }

        int p1 = 0, p2 = list.size() - 1;
        while (p1 < p2)
        {
            if (!list.get(p1).equals(list.get(p2)))
            {
                return false;
            }
            p1++;
            p2--;

        }
        return true;
    }


    // 翻转后半部分链表
    public boolean isPalindrome2(ListNode head)
    {

        // 找到中间位置
        ListNode p1 = head, mid = head;
        while (p1 != null && p1.next != null)
        {
            p1 = p1.next.next;
            mid = mid.next;
        }

        // 翻转后半部分
        ListNode prev = null;  // 翻转后的头部
        ListNode cur = mid;
        while (cur != null)
        {
            ListNode tempNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tempNode;
        }


        p1 = head;
        while (prev != null)
        {
            if (p1.val != prev.val)
            {
                return false;
            }
            p1 = p1.next;
            prev = prev.next;
        }


        return true;

    }

    // [1,2,3,2,1]
    // 优化版翻转链表,在找中间节点时，同时翻转前半部分链表
    public boolean isPalindrome3(ListNode head)
    {

        ListNode p1 = head;
        ListNode mid = head;
        ListNode cur = head;
        ListNode prev = null;
        while (p1 != null && p1.next != null)
        {
            // 找到中间节点
            mid = mid.next;
            p1 = p1.next.next;

            // 翻转前半部分链表
            ListNode tempNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tempNode;
        }
        // 如果链表长度是 奇数
        if (p1 != null)
        {
            mid = mid.next;
        }

        while (prev != null)
        {
            if (mid.val != prev.val)
            {
                return false;
            }
            prev = prev.next;
            mid = mid.next;
        }

        return true;

    }

    // 递归
    public boolean isPalindrome(ListNode head)
    {

    }
}
// leetcode submit region end(Prohibit modification and deletion)
