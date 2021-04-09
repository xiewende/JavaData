package 链表;

import java.util.List;

/**
 * @create 2021-02-08  13:55
 */
public class one_four_one_环行链表 {

    /*
    分析：
    设置两个指针，一个快指针，一个慢指针
    先判断是否有环，使用上一题的解法，采取同一个起点
    判断完有环后，找到环的起始点，此时slow指针指向原来快慢指针相遇的节点
    使fast为头节点，接下来使快慢指针往后走，相遇即为起始点。
    */
    //起点相差一个型
    public boolean hasCycle(ListNode head) {

        if(head== null || head.next == null){
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast!=slow){
            if(fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    //起点相差两个型
    public boolean hasCycle1(ListNode head) {

        if(head== null || head.next == null || head.next.next == null){
            return false;
        }
        ListNode fast = head.next.next;
        ListNode slow = head;

        while (fast!=slow){
            if(fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    //起点相同型,这种方式才可以解决环行链表2的题目，找到环的起始点
    public boolean hasCycle3(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;

        while (true){
            if(fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                break;
            }
        }
        return true;
    }


}
