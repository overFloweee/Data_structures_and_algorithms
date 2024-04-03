// 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//
//
// 示例 1：
//
//
// 输入：l1 = [2,4,3], l2 = [5,6,4]
// 输出：[7,0,8]
// 解释：342 + 465 = 807.
//
//
// 示例 2：
//
//
// 输入：l1 = [0], l2 = [0]
// 输出：[0]
//
//
// 示例 3：
//
//
// 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
// 输出：[8,9,9,9,0,0,0,1]
//
//
//
//
// 提示：
//
//
// 每个链表中的节点数在范围 [1, 100] 内
// 0 <= Node.val <= 9
// 题目数据保证列表表示的数字不含前导零
//
//
// Related Topics 递归 链表 数学 👍 10372 👎 0


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
    // 给了超出 long 的数据，无语
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2)
    {
        ListNode p1 = l1;
        ListNode p2 = l2;
        long num = 0L;
        long x = 1;
        while (l1 != null)
        {
            num += l1.val * x;
            x = x * 10;
            l1 = l1.next;
        }
        x = 1;

        while (l2 != null)
        {
            num += l2.val * x;
            x = x * 10;
            l2 = l2.next;
        }

        System.out.println(num);
        ListNode sentinel = new ListNode(-1);
        ListNode p = sentinel;
        while (true)
        {
            long temp = num % 10;
            p.next = new ListNode((int) temp);
            p = p.next;
            if (num / 10 == 0)
            {
                break;
            }
            num /= 10;
        }

        return sentinel.next;
    }


    // 我的解法 击败1%
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2)
    {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode sentinel = new ListNode(-1);
        ListNode p = sentinel;
        int temp;

        while (p1 != null || p2 != null)
        {
            temp = 0;

            if (p1 == null)
            {
                temp = p2.val;
                p2 = p2.next;
            }
            else if (p2 == null)
            {
                temp = p1.val;
                p1 = p1.next;
            }
            else
            {
                temp = p1.val + p2.val;
                p1 = p1.next;
                p2 = p2.next;
            }
            p.next = new ListNode(temp);
            p = p.next;


        }


        p = sentinel;
        ListNode p3 = p.next;
        int tempNum = 0;
        while (p.next != null)
        {
            if (p3.val >= 10)
            {
                if (p3.next == null)
                {
                    p3.next = new ListNode(0);
                }


                tempNum = p3.next.val;
                p3.next.val = tempNum + 1;
                p3.val = p3.val % 10;
                System.out.print(p3.val + ",");
                p3 = p3.next;

            }
            else
            {
                p = p.next;
                p3 = p.next;
            }


        }

        return sentinel.next;

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode sentinel = new ListNode(-1);

        ListNode prev = sentinel;
        ListNode p = prev.next;

        int temp;

        while (p1 != null || p2 != null)
        {
            // 相加
            temp = 0;

            if (p1 == null)
            {
                temp = p2.val;
                p2 = p2.next;
            }
            else if (p2 == null)
            {
                temp = p1.val;
                p1 = p1.next;
            }
            else
            {
                temp = p1.val + p2.val;
                p1 = p1.next;
                p2 = p2.next;

            }


            // 存储，如果 > 10 就进位
            if (p != null)
            {
                p.val = p.val + temp;
            }
            else
            {
                prev.next = new ListNode(temp);
                p = prev.next;
            }

            if (p.val >= 10)
            {
                p.next = new ListNode(1);
                p.val = p.val % 10;
            }


            p = p.next;
            prev = prev.next;
        }
        return sentinel.next;

    }
}
// leetcode submit region end(Prohibit modification and deletion)
