package 链表;

/**
 * @create 2020-02-10  10:15
 */
public class Node {
    String cur_address;
    int data;
    String next_address;
    Node next;

    public String getCur_address() {
        return cur_address;
    }

    public void setCur_address(String cur_address) {
        this.cur_address = cur_address;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String getNext_address() {
        return next_address;
    }

    public void setNext_address(String next_address) {
        this.next_address = next_address;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
