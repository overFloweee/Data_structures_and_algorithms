package study;

import study.SinglyLinkedList.ListNode;

public class test1
{
    public static void main(String[] args)
    {
        //
        // SinglyLinkedList list = new SinglyLinkedList();
        // list.addLast(1);
        // list.addLast(1);
        //
        // boolean palindrome = isPalindrome(list.head);
        // System.out.println(palindrome);

        // int n = 16;
        // boolean powerOfTwo = isPowerOfTwo(n);
        // System.out.println(powerOfTwo);

        SinglyLinkedList p1 = new SinglyLinkedList();
        p1.addLast(9);
        p1.addLast(9);
        p1.addLast(9);
        p1.addLast(9);
        SinglyLinkedList p2 = new SinglyLinkedList();
        p2.addLast(9);
        p2.addLast(9);
        p2.addLast(9);
        p2.addLast(9);
        p2.addLast(9);
        p2.addLast(9);
        p2.addLast(9);

        ListNode sentinel = new ListNode(-1);
        ListNode p = sentinel;
        int temp;

        // while (p1 != null && p2 != null)
        // {
        //     temp = 0;
        //     if (p1 == null)
        //     {
        //         temp = p2.val;
        //         p2 = p2.next;
        //     }
        //     else if (p2 == null)
        //     {
        //
        //         temp = p1.val;
        //         p1 = p1.next;
        //     }
        //     else
        //     {
        //         temp = p1.val + p2.val;
        //         p1 = p1.next;
        //         p2 = p2.next;
        //     }
        //     p.next = new ListNode(temp);
        //     p = p.next;
        // }
    }

    public static boolean isPowerOfTwo(int n)
    {
        if (n == 1)
        {
            return true;
        }
        int p1 = 0, p2 = n - 1;
        while (p1 <= p2)
        {
            int m = (p1 + p2) >>> 1;
            if (Math.pow(2,m) > n)
            {
                p2 = m - 1;
            }
            else if (Math.pow(2,m) < n)
            {
                p1 = m + 1;

            }
            else
            {
                return true;
            }
        }
        return false;

    }


    // 翻转后半部分链表
    public static boolean isPalindrome(ListNode head)
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
}
