package study;

public class SinglyLinkedList
{

    public ListNode head; // 头部节点

    public void addFirst(int value)
    {
        this.head = new ListNode(value, this.head);
    }

    private ListNode findLast()
    {
        if (this.head == null)
        {
            return null;
        }
        ListNode curr;
        for (curr = this.head; curr.next != null; )
        {
            curr = curr.next;
        }
        return curr;
    }

    public void addLast(int value)
    {
        ListNode last = findLast();
        if (last == null)
        {
            addFirst(value);
            return;
        }
        last.next = new ListNode(value, null);
    }


    public static class ListNode
    {
        // 节点类
        int val;
        ListNode next;

        public ListNode(int value, ListNode next)
        {
            this.val = value;
            this.next = next;
        }
        public ListNode(int value)
        {
            this.val = value;
        }


        // 遍历
        public void loop()
        {
            ListNode p = this;
            while (p != null)
            {
                System.out.print(p.val + ",");
                p = p.next;
            }

        }

    }
}
