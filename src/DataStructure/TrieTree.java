package DataStructure;

/**
 * @author ：mzr
 * @date ：Created in 2020/5/18 11:45
 * @description：字典树
 * @modified By：
 */


public class TrieTree {

    public class TrieNode {
        public char data;
//        利用数组存储26位字母
        public TrieNode[] children = new TrieNode[26];
        public boolean isEndingChar = false;

        public TrieNode(char data) {

            this.data = data;
        }
    }

    // 存储无意义字符,根节点
    private TrieNode root = new TrieNode('/');

    // 往Trie树中插入一个字符串
    public void insert(char[] text) {
        TrieNode p = root;
        for (int i = 0; i < text.length; ++i) {
//            找到字符对应的下标
            int index = text[i] - 'a';
            if (p.children[index] == null) {
                TrieNode newNode = new TrieNode(text[i]);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    // 在Trie树中查找一个字符串
    public boolean find(char[] pattern) {
        TrieNode p = root;
        for (int i = 0; i < pattern.length; ++i) {
            int index = pattern[i] - 'a';
            if (p.children[index] == null) {
                return false; // 不存在pattern
            }
            p = p.children[index];
        }
        if(!p.isEndingChar) return false; // 不能完全匹配，只是前缀
        else return true; // 找到pattern
    }


}
