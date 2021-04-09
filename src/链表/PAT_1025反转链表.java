package 链表;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * @create 2020-02-10  10:18
 */
public class PAT_1025反转链表 {

    public static void main(String[] args) {
        //System.out.println(6/4);
        //  System.out.println(6/3);
        one();

    }

    public static void one() {
        //存储首地址对应的节点
        Map<String, Node> nodeMap = new HashMap<>();


        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        String str = sc.nextLine();
        String strs[] = str.split(" ");
        String head_adress = strs[0];
        int N = Integer.valueOf(strs[1]);
        int K = Integer.valueOf(strs[2]);
        System.out.println("N=" + N);
        System.out.println("K=" + K);

        for (int i = 0; i < N; i++) {
            str = sc.nextLine();
            strs = str.split(" ");
            String curr_adress = strs[0];
            int data = Integer.valueOf(strs[1]);
            String next_adress = strs[2];
            Node node = new Node();
            node.setCur_address(curr_adress);
            node.setData(data);
            node.setNext_address(next_adress);
            //放到map集合中
            nodeMap.put(curr_adress, node);
        }

        //遍历一下map
        Set<String> keys = nodeMap.keySet(); // 遍历键集 得到 每一个键
        for (String key : keys) {
            //key 就是键 //获取对应值
            Node node = nodeMap.get(key);
            if (node.getNext_address() == "-1") {
                node.setNext(null);
            } else {
                node.setNext(nodeMap.get(node.getNext_address()));
            }

        }

        //查找到首节点
        Node head_node = nodeMap.get(head_adress);

        //真实长度，中间可能两个-1
        int num = 0;
        while (head_node != null) {
            num++;
            head_node = head_node.next;
        }
        System.out.println("num=" + num);

        head_node = nodeMap.get(head_adress);

        System.out.println("初始顺序：");
        for (int j = 0; j < num; j++) {
            System.out.print(head_node.getData() + "->");
            head_node = head_node.getNext();
        }
        System.out.println();


        head_node = nodeMap.get(head_adress);


        //进行反转
        //反转次数
        int count = num / K;
        System.out.println("反转次数：" + count);

        for (int k = 1; k <= count; k++) {
            if (k == 1) {//第一次反转需要改变头节点
                head_node = reverseBetween(head_node, k, k * K);
            } else {
                reverseBetween(head_node, (k - 1) * K + 1, k * K);
            }
        }

        System.out.println("反转后顺序：");
        for (int j = 0; j < num; j++) {

            //改变后继地址
            if (head_node.next == null) {
                head_node.setNext_address("-1");
            } else {
                head_node.setNext_address(head_node.next.getCur_address());
            }
            System.out.println(head_node.getCur_address() + " " + head_node.getData() + "  " + head_node.getNext_address());
            head_node = head_node.getNext();
        }

    }

    //反转函数 传入的为开始和结束 反转指定两个位置
    public static Node reverseBetween(Node head, int m, int n) {
        Node cur_head = head;
        Node cur = null;
        Node pre = null;
        Node lasts = null;
        //ListNode last = null;
        //拿到n和m对应的节点
        for (int i = 1; i <= n; i++) {
            if (i == m - 1) {
                pre = head;
            }
            if (i == m) {
                cur = head;
            }
            if (i == n) {
                // last = head;
                lasts = head.next;
            }
            head = head.next;
        }

        Node pres = pre;
        Node curs = cur;
        //进行反转
        while (true) {

            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            if (cur == lasts) {
                break;
            }
        }


        if (m == 1) {
            curs.next = lasts;
            return pre;
        } else {
            pres.next = pre;
            curs.next = lasts;
            return cur_head;
        }

    }
}
