package 链表;

/**
 * @create 2019-09-09  20:42
 */
public class tow_zero_three_移除链表元素 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0); //虚拟的头节点
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null) {
            if (cur.next.val == val) {
                //删除相应的节点
                ListNode delNode = cur.next;
                cur.next = delNode.next;
            } else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}



