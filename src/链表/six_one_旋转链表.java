package 链表;

import 链表.ListNode;

/**
 * @create 2019-09-14  21:57
 */
public class six_one_旋转链表 {

    public static void main(String[] args) {

    }

    public ListNode rotateRight(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead;
        ListNode q = dummyHead;
        ListNode last = dummyHead;

        while (last != null) {
            last = last.next;
        }
        for (int i = 0; i < k + 1; i++) {
            q = q.next;
        }
        while (q != null) {
            p = p.next;
            q = q.next;
        }

        ListNode heads = p.next;
        p.next = null;
        last.next = dummyHead.next;

        return heads;
    }
}
