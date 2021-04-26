package utils;

/**
 * @date 2020/12/14 15:15
 */
public class BaseTreeNode<T, V> {

    public V val;
    public T left;
    public T right;

    public BaseTreeNode() {
    }

    public BaseTreeNode(V val) {
        this.val = val;
    }
}
