import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wjw
 * @date 2021/4/14 23:19
 */
public class two_zero_eight_实现Trie前缀树 {

    @Test
    public void test(){
        Trie trie = new Trie();
//        trie.insert("apple");
        trie.insert("p");
        trie.insert("pr");
        trie.search("pr");
        trie.insert("app");

        System.out.println(trie.search("abc"));
        System.out.println(trie.search("app"));
        System.out.println(trie.search("abd"));
    }
}

class Trie {

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] ch = word.toCharArray();
        List<TrieNode> children = root.children;
        int j;
        for (int i = 0; i < ch.length; i++) {
            //遍历
            int len = children.size();
            j = 0;
            while (j < len) {
                if (ch[i] == children.get(j).val) {
                    if(i == ch.length - 1)  children.get(j).isEnd = true;
                    children = children.get(j).children;
                    break;
                }
                j++;
            }
            if (j == len) { // 说明没有找到
                boolean isEnd = (i == ch.length - 1);
                children.add(new TrieNode(ch[i], isEnd));
                children = children.get(j).children;
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] ch = word.toCharArray();
        List<TrieNode> children = root.children;
        int j;
        for (int i = 0; i < ch.length; i++) {
            int len = children.size();
            j = 0;
            while (j < len) {
                if (ch[i] == children.get(j).val) {
                    if(i == ch.length - 1) return children.get(j).isEnd;
                    children = children.get(j).children;
                    break;
                }
                j++;
            }
            if (j == len) { // 说明没有找到
                return false;
            }
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] ch = prefix.toCharArray();
        List<TrieNode> children = root.children;
        for (char c : ch) {
            int j = 0, len = children.size();
            while (j < len) {
                if (c == children.get(j).val) {
                    children = children.get(j).children;
                    break;
                }
                j++;
            }
            if (j == len) { // 说明没有找到
                return false;
            }
        }
        return true;
    }
}

/* | val | children | */
class TrieNode{
    char val;
    boolean isEnd = false;
    List<TrieNode> children = new ArrayList<>();

    public TrieNode(){
    }

    public TrieNode(char val){
        this.val = val;
    }

    public TrieNode(char val, boolean isEnd){
        this.val = val;
        this.isEnd = isEnd;
    }
}

/**
 * 别人的做法，思想差不多，写的很简洁
 */
class TrieOther {
    TrieOther []child = new TrieOther[26];
    boolean isEnd = false;
    /** Initialize your data structure here. */
    public TrieOther() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieOther t = find(word,true);
        t.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieOther t = find(word,false);
        return t!=null && t.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieOther t = find(prefix,false);
        return t!=null;
    }

    private TrieOther find(String word, boolean insertMode){
        TrieOther t = this;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i)-'a';
            if(t.child[index]==null){
                if(insertMode){
                    t.child[index] = new TrieOther();
                }else{
                    return null;
                }
            }
            t = t.child[index];
        }
        return t;
    }
}