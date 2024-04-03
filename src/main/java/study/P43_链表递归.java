package study;

import study.SinglyLinkedList.ListNode;

import java.util.List;

public class P43_链表递归
{
    public static void main(String[] args)
    {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(5);
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);  // [1,2,3,4,5]

        // SinglyLinkedList.ListNode ListNode = recursion(list.head);
        // System.out.println(ListNode.value);

        // SinglyLinkedList.ListNode ListNode = reverseList(list.head);
        // System.out.println(ListNode.value);


        SinglyLinkedList list1 = new SinglyLinkedList();
        list1.addFirst(6);
        list1.addFirst(5);
        list1.addFirst(4);
        list1.addFirst(3);
        list1.addFirst(6);
        list1.addFirst(2);
        list1.addFirst(1);
        // removeElements(list1.head, 6);
        System.out.println(list1.head);


        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.addFirst(6);
        list2.addFirst(4);
        list2.addFirst(2);

        SinglyLinkedList list3 = new SinglyLinkedList();
        list3.addFirst(7);
        list3.addFirst(3);
        list3.addFirst(1);

        ListNode listNode = mergeTwoLists(list2.head, list3.head);
        listNode.loop();
    }


    public static SinglyLinkedList.ListNode recursion(SinglyLinkedList.ListNode p)
    {

        if (p == null)
        {
            return p;
        }

        System.out.println("before:" + p.val);
        SinglyLinkedList.ListNode ListNode = recursion(p.next);
        System.out.println("after:" + p.val);

        return ListNode;

    }


    // L206
    public static SinglyLinkedList.ListNode reverseList(SinglyLinkedList.ListNode p)
    {
        if (p == null || p.next == null)
        {
            return p;
        }

        SinglyLinkedList.ListNode newHead = reverseList(p.next);
        p.next.next = p;
        p.next = null;
        return newHead;
    }

    // L203
    public static SinglyLinkedList.ListNode removeElements(SinglyLinkedList.ListNode p, int val)
    {
        if (p == null)
        {
            return null;
        }

        if (p.val == val)
        {
            return removeElements(p.next, val);
        }
        else
        {
            p.next = removeElements(p.next, val);
            return p;
        }
    }

    // L21
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


        if (l1.val < l2.val)
        {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else
        {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }
}
