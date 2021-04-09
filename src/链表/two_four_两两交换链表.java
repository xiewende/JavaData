package 链表;

/**
 * @create 2019-09-14  20:41
 */
public class two_four_两两交换链表 {

    public static void main(String[] args) {

    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead;

        while (p.next != null && p.next.next != null) {

            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;
            //交换
            node2.next = node1;
            node1.next = next;
            p.next = node2;
            p = node1;

        }

        return dummyHead.next;

    }
}
