package study;

import study.SinglyLinkedList.ListNode;

public class P42_链表练习
{
    public static void main(String[] args)
    {
        // SinglyLinkedList list1 = new SinglyLinkedList();
        // list1.addLast(1);
        // list1.addLast(3);
        // list1.addLast(6);
        //
        // SinglyLinkedList list2 = new SinglyLinkedList();
        // list2.addLast(2);
        // list2.addLast(5);
        // list2.addLast(8);
        //
        // ListNode listNode = mergeTwoLists(list1.head, list2.head);
        //
        // listNode.loop();

        SinglyLinkedList list1 = new SinglyLinkedList();
        list1.addLast(1);
        list1.addLast(1);
        list1.addLast(2);
        ListNode listNode = deleteDuplicates(list1.head);
        listNode.loop();
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {

        if (l1 == null)
        {
            return l2;
        }
        else if (l2 == null)
        {
            return l1;
        }
        else if (l1.val < l2.val)
        {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else
        {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
        // 1,2
        // 3,2
        // 3,5
        // 6,5
        // 6,8

    }


    public static ListNode deleteDuplicates(ListNode head)
    {
        ListNode prev = head;
        ListNode p = prev.next;
        while (p != null)
        {
            if (prev.val == p.val)
            {
                prev.next = p.next;
                p = p.next;

            }
            else
            {
                prev = prev.next;
                p = p.next;
            }
        }

        return head;

    }


}
