/**
 * @author wjw
 * @date 2021/3/14 23:10
 */
public class seven_zero_six_设计哈希映射 {

    class MyHashMap {
        private int YU = 10000;
        private Node[] mymap;

        /** Initialize your data structure here. */
        public MyHashMap() {
            mymap = new Node[YU];
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int idx = key % YU;
            while(mymap[idx] != null && mymap[idx].k != -1){  //被占用
                if(mymap[idx].k == -2) {   //被清空的位置其实是可用的
                    mymap[idx].k = key;
                    mymap[idx].v = value;
                    return ;
                }
                if(mymap[idx].k == key) {   //找到了相同的key
                    mymap[idx].v = value;
                    return ;
                }
                idx = (idx + 1) % YU;
            }
            mymap[idx] = new Node(key, value);
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int idx = key % YU;
            int count = 0;
            if(mymap[idx] == null) return -1;
            while(mymap[idx].k != key){ //遍历找到当前的key
                idx = (idx + 1) % YU;
                count++;
                if(mymap[idx] == null || mymap[idx].k == -1 || count == YU){
                    return -1;
                }
            }
            return mymap[idx].v;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int idx = key % YU;
            if(mymap[idx] == null) return ;
            while(mymap[idx].k != key){ //遍历找到当前的key
                if(mymap[idx].k == -1) return ; //如果遇到了-1，说明数组中根本没有需要remove的值
                idx = (idx + 1) % YU;
                if(mymap[idx] == null) return ;
            }
            mymap[idx].k = -2;
        }

        class Node{
            int k = -1;
            int v = -1;

            public Node(){
            }

            public Node(int k, int v){
                this.k = k;
                this.v = v;
            }
        }
    }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
}
