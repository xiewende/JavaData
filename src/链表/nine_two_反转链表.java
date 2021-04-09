package 链表;

/**
 * @create 2019-11-29  18:22
 */
public class nine_two_反转链表 {
    public static void main(String[] args) {

    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode cur_head = head;
        ListNode cur = null;
        ListNode pre = null;
        //ListNode next = null;
        ListNode last = null;
        //拿到n和m对应的节点
        for (int i = 1; i <= n; i++) {

            if (i == m - 1) {
                pre = head;
            }
            if (i == m) {
                cur = head;
            }
            if (i == n) {
                last = head;
            }
            head = head.next;
        }

        //return pre;

        ListNode pres = pre;
        ListNode curs = cur;
        //进行反转
        while (true) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            if (cur == last.next) {
                break;
            }
        }

        pres.next = pre;
        curs.next = last.next;

        if (m == 1) {
            return pre;
        } else {
            return cur_head;
        }

    }
}
