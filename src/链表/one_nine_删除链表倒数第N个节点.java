package 链表;

/**
 * @create 2019-09-14  21:13
 */
public class one_nine_删除链表倒数第N个节点 {

    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead;
        ListNode q = dummyHead;

        for (int i = 0; i < n + 1; i++) {
            q = q.next;
        }
        while (q != null) {
            p = p.next;
            q = q.next;
        }

        ListNode delNode = p.next;
        p.next = delNode.next;

        return dummyHead.next;
    }
}
