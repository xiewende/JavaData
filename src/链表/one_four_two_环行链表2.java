package 链表;

/**
 * @create 2021-02-08  13:55
 */
public class one_four_two_环行链表2 {

    public ListNode detectCycle(ListNode head) {

        //先判断是否有环
        if(head== null){
            return null;
        }
        //统一起点
        ListNode fast = head;
        ListNode slow = head;
        while (true){
            if(fast == null || fast.next == null){ //
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        //有环了，判断起点
        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
