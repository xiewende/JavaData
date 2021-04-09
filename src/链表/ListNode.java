package 链表;

/**
 * @create 2019-11-29  19:22
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public ListNode deleteDuplicates(ListNode head, int x) {
        ListNode node = null;
        ListNode node_head = null;
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val >= x) {
                if (node == null) {
                    node = current.next;
                    node_head = node;
                } else {
                    ListNode node1 = current.next;
                    node.next = node1;
                    node = node1.next;
                }
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        current.next = node_head;

        return head;

    }
}
